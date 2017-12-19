package com.company.Tasks.Task1;

import com.company.Tasks.Task1.enums.Task1Response;
import com.mashape.unirest.http.HttpResponse;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;


import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class task1 extends Application{
    ExecutorService pool = Executors.newFixedThreadPool(4);
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        TextField textSearching=new TextField("UC6cqazSR6CnVMClY0bJI0Lg");
        textSearching.setTranslateX(10);
        textSearching.setTranslateY(10);
        Button sendSearch = new Button("Search");
        sendSearch.setTranslateX(180);
        sendSearch.setTranslateY(10);
        root.getChildren().addAll(textSearching,sendSearch);
        sendSearch.setOnMouseClicked((event -> {
            String id = textSearching.getText();
            pool.submit(()->{
                HttpResponse<Task1Response> response = task1Client.getSearching(id);
                System.out.println("Response Code: "+ response.getStatus());
                Task1Response body = response.getBody();
                Platform.runLater(()->{
                    printResult(root,body);
                });
            });
        }));
        primaryStage.setScene(new Scene(root));
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.show();

    }

    private void printResult(Pane root, Task1Response body) {
        ImageView imageView = new ImageView();
        imageView.setFitWidth(500);
        imageView.setFitHeight(500);
        root.getChildren().add(imageView);
    }
    }