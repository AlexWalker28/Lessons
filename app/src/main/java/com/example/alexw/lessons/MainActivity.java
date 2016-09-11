package com.example.alexw.lessons;

import android.app.Service;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.Persistence;
import com.backendless.UserService;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    final String[] text = new String[1];



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        textView = (TextView) findViewById(R.id.textView);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String appVersion = "v1";
        Backendless.initApp(this, "84699694-079F-E281-FFC6-0A251E47C500", "2E0782F0-954C-C2F3-FF8E-0622827A1700", appVersion);



        /*final BackendlessUser user = new BackendlessUser();
        user.setEmail( "triad28@yandex.ru" );
        user.setPassword( "my_super_password" );

        Backendless.Persistence.save( new Comment( "My comment", user.getEmail() ), new BackendlessCallback<Comment>()
        {
            @Override
            public void handleResponse( Comment comment )
            {
                Log.i( "Comments", "Got new comment from " + user.getEmail() );
            }
        } );*/


        /*Android applications cannot use synchronous APIs on the main UI thread.The reason for this
        is the main thread does not allow blocking calls.Since the API requests perform network
        -based communication, the naturally block.As a result, when using the Backendless APIs
        make sure to use the asynchronous version of the methods, or create a new thread and use
        the synchronous API in it:*/


        /*new Thread(new Runnable() {
            public void run() {
                // synchronous backendless API call here:
                Comment comment = new Comment();
                comment.setMessage("My 2 comment");
                comment.setAuthorEmail("triad28@yandex.ru");
                Backendless.Data.of(Comment.class).save(comment);






            }
        }).start();*/


        /*deleteComment();*/

        retrieveComment();
        textView.setText(Arrays.toString(text));






    }


    private void retrieveComment() {
        Comment comment = new Comment();
        comment.setMessage("May be now?");
        comment.setAuthorEmail("triad28@yandex.ru");
        Backendless.Persistence.save(Comment.class, new AsyncCallback<Class<Comment>>() {
            @Override
            public void handleResponse(Class<Comment> commentClass) {

            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {

            }
        });



       Backendless.Persistence.of(Comment.class).find(new AsyncCallback<BackendlessCollection<Comment>>() {
           @Override
           public void handleResponse(BackendlessCollection<Comment> commentBackendlessCollection) {
              List<Comment> commentList = commentBackendlessCollection.getData();
              text[0] = commentList.toString();


           }

           @Override
           public void handleFault(BackendlessFault backendlessFault) {

           }
       });
    }



    public void deleteComment(){
        Comment comment = new Comment();
        comment.setMessage("May be now?");
        comment.setAuthorEmail("triad28@yandex.ru");

        Backendless.Persistence.save(comment, new AsyncCallback<Comment>() {
            @Override
            public void handleResponse(Comment comment) {
                Backendless.Persistence.of(Comment.class).remove(comment, new AsyncCallback<Long>() {
                    @Override
                    public void handleResponse(Long aLong) {

                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {

                    }
                });

            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {

            }
        });












    }







}
