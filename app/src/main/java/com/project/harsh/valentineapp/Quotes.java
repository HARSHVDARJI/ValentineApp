package com.project.harsh.valentineapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Quotes extends AppCompatActivity {

    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandlist1);

        TextView txt = (TextView) findViewById(R.id.quotetxt);
        Intent intent = getIntent();
        final String quotes = intent.getStringExtra("quotePos");

        txt.setText(quotes);

//        Button sharebtn = (Button) findViewById(R.id.exp_share);
//        sharebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
//                sharingIntent.setType("text/html");
//                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml(quotes));
//                startActivity(Intent.createChooser(sharingIntent, "Share using"));
//            }
//        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.share, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.sharebtn) {

            openShareMenu();
        }
        else if(id == android.R.id.home){
            finish();
        }


        return super.onOptionsItemSelected(item);
    }

    public void openShareMenu(){

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);//android.content.Intent.ACTION_SEND
        sharingIntent.setType("text/plain");
//        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "quotes");
//        String shareText = "this is the share text";
        Intent intent = getIntent();
        final String quotes = intent.getStringExtra("quotePos");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, quotes);


        //display apps that support the intent
//        List<ResolveInfo> respondingApps = getPackageManager().queryIntentActivities(sharingIntent,0);
//        for(ResolveInfo ri : respondingApps){
//            ComponentName name = new ComponentName(ri.activityInfo.packageName,ri.activityInfo.name);
//            Log.v("TAG", "-->" + ri.loadLabel(getPackageManager()));
//        }

        startActivity(Intent.createChooser(sharingIntent, "Share using"));
    }
}

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.share, menu);
//        MenuItem shareItem = menu.findItem(R.id.sharebtn);
//        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if(id==R.id.sharebtn)
//        {
//            doShare();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void doShare() {
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/html");
//        intent.putExtra(Intent.EXTRA_TEXT,"quotes");
//        mShareActionProvider.setShareIntent(intent);
//
//    }
//}

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.share, menu);
//        = (ShareActionProvider) menu.findItem(R.id.sharebtn)
//                .getActionProvider();
//        mShareActionProvider.setShareIntent(doShare());
//        return true;
//    }
//
//    private Intent doShare() {
//        Intent intent = new Intent(Intent.ACTION_SEND)
//                .setType("text/plain").putExtra(Intent.EXTRA_TEXT, "quotePos");
//        return intent;
//    }
//}
//        Button sharebtn = (Button)findViewById(R.id.action_name);
//        sharebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
//                sharingIntent.setType("text/html");
//                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml(quotes));
//                startActivity(Intent.createChooser(sharingIntent, "Share using"));
//            }
//        });

