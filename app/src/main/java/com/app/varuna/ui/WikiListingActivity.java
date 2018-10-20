package com.app.varuna.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.varuna.R;
import com.app.varuna.adapter.WikiListingAdapter;
import com.app.varuna.api.ApiClient;
import com.app.varuna.api.ApiInterface;
import com.app.varuna.model.Page;
import com.app.varuna.model.Wiki;
import com.app.varuna.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WikiListingActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.error_txt)
    TextView errorTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_listing);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getDataToLoad("Sachin T");
        if (!Utils.haveNetworkConnection(this)) {
            Toast.makeText(WikiListingActivity.this, "Loading offline data, please check your intent connection", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                showDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showDialog() {
        final View view = getLayoutInflater().inflate(R.layout.dialog_with_txt_input, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(WikiListingActivity.this).create();
        alertDialog.setTitle("Search");
        alertDialog.setCancelable(false);
        final EditText editText = (EditText) view.findViewById(R.id.inputTxt);

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getDataToLoad(editText.getText().toString().trim());
                alertDialog.dismiss();
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.setView(view);
        alertDialog.show();
    }

    private void getDataToLoad(String searchTxt) {
        errorTxt.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        ApiInterface apiService = ApiClient.getClient(this).create(ApiInterface.class);

        Call<Wiki> call = apiService.getWikiData(
                "query",
                "json",
                "pageimages|pageterms|info",
                "1",
                "prefixsearch",
                "1",
                "2",
                "thumbnail",
                "100",
                "10",
                "description",
                "url",
                searchTxt,
                "10");
        call.enqueue(new Callback<Wiki>() {
            @Override
            public void onResponse(Call<Wiki> call, Response<Wiki> response) {
                List<Page> pageList = response.body().getQuery().getPages();
                errorTxt.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                recyclerView.setAdapter(new WikiListingAdapter(pageList, R.layout.list_item_wiki, WikiListingActivity.this));
            }

            @Override
            public void onFailure(Call<Wiki> call, Throwable t) {
                errorTxt.setText("No data available");
                errorTxt.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
