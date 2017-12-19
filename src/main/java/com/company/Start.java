package com.company;

import com.company.Tasks.Task1.enums.Task1ActivityItem;
import com.company.Tasks.Task1.enums.Task1ActivityItemSnippet;
import com.company.Tasks.Task1.enums.Task1Response;
import com.company.Tasks.Task1.task1Client;
import com.mashape.unirest.http.HttpResponse;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Start extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public static final int width = 1120;
    public static final int height = 750;
    private Scene youtube;
    private Scene settings;
    private Scene menu;
    @FXML
    private TextField textField;
    private Label channeltitlee;
    public void buttonBack(Stage primaryStage, Pane root, Scene youtube){
        Button btnBack = new Button("Back");
        btnBack.setTranslateX(1040);
        btnBack.setTranslateY(230);
        btnBack.setMinWidth(60);
        btnBack.setMinHeight(30);
        btnBack.setStyle("-fx-font: 20  CenturyGothic; -fx-base: #000000;");
        btnBack.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(youtube);
            }
        });

        root.getChildren().addAll(btnBack);
    }

    public void buttons(Stage primaryStage, Pane root, Scene youtube, Scene settings) {
        int distanceY = 250;
        int distanceX = 0;
        Button btnHome = new Button("Home");
        Button btnYoutube = new Button("Youtube Analytics");
        Button btnSettings = new Button("Settings");
        btnHome.setTranslateX(distanceX);
        btnHome.setTranslateY(distanceY);
        btnHome.setMinWidth(345);
        btnHome.setMinHeight(100);
        btnHome.setStyle("-fx-font: 30  CenturyGothic; -fx-base: #000000;");
        btnYoutube.setTranslateX(distanceX);
        btnYoutube.setTranslateY(distanceY + distanceY / 2);
        btnYoutube.setMinWidth(345);
        btnYoutube.setMinHeight(100);
        btnYoutube.setStyle("-fx-font: 24pt CenturyGothic; -fx-base: #000000;");
        btnSettings.setTranslateX(distanceX);
        btnSettings.setTranslateY(distanceY + distanceY);
        btnSettings.setMinWidth(345);
        btnSettings.setMinHeight(100);
        btnSettings.setStyle("-fx-font:30 CenturyGothic; -fx-base: #000000;");


        btnYoutube.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(youtube);
            }
        });

        btnSettings.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(settings);
            }
        });
        btnHome.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(menu);
            }
        });
        root.getChildren().addAll(btnHome, btnYoutube, btnSettings);

    }

    private void initSettingsViews(Stage primaryStage, Pane root) {
        buttons(primaryStage, root, youtube, settings);

    }

    private Scene initSettings(Stage primaryStage) {
        Pane root = new Pane();
        try {
            root = FXMLLoader.load(getClass().getResource("/settings.fxml"));
            initSettingsViews(primaryStage, root);

        } catch (Exception e) {
        }
        return new Scene(root);
    }

    private void initYoutubeViews(Stage primaryStage, Pane root) {
        buttons(primaryStage, root, youtube, settings);
        int distanceX = 560;
        int distanceY = 330;
        int y = 60;
        Button btn1 = new Button("Channel information");
        Button btn2 = new Button("Compare channel information");
        Button btn3 = new Button("Sort channels");
        Button btn4 = new Button("Media Resonance");
        Button btn5 = new Button("Compare Media Resonance");
        Button btn6 = new Button("Sort by Media Resonance");
        btn1.setTranslateX(distanceX);
        btn1.setTranslateY(distanceY);
        btn1.setMinWidth(300);
        btn1.setMinHeight(50);
        btn1.setStyle("-fx-font: 18  CenturyGothic; -fx-base: #000000;");
        btn2.setTranslateX(distanceX);
        btn2.setTranslateY(distanceY + y);
        btn2.setMinWidth(300);
        btn2.setMinHeight(50);
        btn2.setStyle("-fx-font: 18  CenturyGothic; -fx-base: #000000;");
        btn3.setTranslateX(distanceX);
        btn3.setTranslateY(distanceY + y*2);
        btn3.setMinWidth(300);
        btn3.setMinHeight(50);
        btn3.setStyle("-fx-font: 18  CenturyGothic; -fx-base: #000000;");
        btn4.setTranslateX(distanceX);
        btn4.setTranslateY(distanceY + y*3);
        btn4.setMinWidth(300);
        btn4.setMinHeight(50);
        btn4.setStyle("-fx-font: 18  CenturyGothic; -fx-base: #000000;");
        btn5.setTranslateX(distanceX);
        btn5.setTranslateY(distanceY + y*4);
        btn5.setMinWidth(300);
        btn5.setMinHeight(50);
        btn5.setStyle("-fx-font: 18  CenturyGothic; -fx-base: #000000;");
        btn6.setTranslateX(distanceX);
        btn6.setTranslateY(distanceY + y*5);
        btn6.setMinWidth(300);
        btn6.setMinHeight(50);
        btn6.setStyle("-fx-font: 18  CenturyGothic; -fx-base: #000000;");

        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(initChannelInfo(primaryStage));
            }
        });
        btn2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(initCompareChannel(primaryStage));
            }
        });
        btn3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(initSortChannel(primaryStage));
            }
        });
        btn4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(initMedia(primaryStage));
            }
        });
        btn5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(initCompareMedia(primaryStage));
            }
        });
        btn6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(initSortMedia(primaryStage));
            }
        });
        root.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6);
    }

    private Scene initSortMedia(Stage primaryStage) {
        Pane root = new Pane();
        try {
            root = FXMLLoader.load(getClass().getResource("/sortMedia.fxml"));
            buttons(primaryStage, root, youtube, settings);
            buttonBack(primaryStage,root,youtube);
        } catch (Exception e) {
        }

        return new Scene(root);
    }

    private Scene initCompareMedia(Stage primaryStage) {
        Pane root = new Pane();
        try {
            root = FXMLLoader.load(getClass().getResource("/compareMedia.fxml"));
            buttons(primaryStage, root, youtube, settings);
            buttonBack(primaryStage,root,youtube);

        } catch (Exception e) {
        }

        return new Scene(root);
    }

    private Scene initMedia(Stage primaryStage) {
        Pane root = new Pane();
        try {
            root = FXMLLoader.load(getClass().getResource("/media.fxml"));
            buttons(primaryStage, root, youtube, settings);
            buttonBack(primaryStage,root,youtube);
        } catch (Exception e) {
        }

        return new Scene(root);
    }

    private Scene initSortChannel(Stage primaryStage) {
        Pane root = new Pane();
        try {
            root = FXMLLoader.load(getClass().getResource("/sort.fxml"));
            buttons(primaryStage, root, youtube, settings);
            buttonBack(primaryStage,root,youtube);
        } catch (Exception e) {
        }

        return new Scene(root);
    }

    private Scene initCompareChannel(Stage primaryStage) {
        Pane root = new Pane();
        try {
            root = FXMLLoader.load(getClass().getResource("/compareChannelInfo.fxml"));
            buttons(primaryStage, root, youtube, settings);
            buttonBack(primaryStage,root,youtube);
        } catch (Exception e) {
        }

        return new Scene(root);
    }
    private Scene initChannelInfo(Stage primaryStage) {
        Pane root = new Pane();
        try {
            root = FXMLLoader.load(getClass().getResource("/channelInformation.fxml"));

            buttons(primaryStage, root, youtube, settings);
            buttonBack(primaryStage,root,youtube);
        } catch (Exception e) {
        }

        return new Scene(root);
    }

    private Scene initYoutube(Stage primaryStage) {
        Pane root = new Pane();
        try {
            root = FXMLLoader.load(getClass().getResource("/youtube.fxml"));
            initYoutubeViews(primaryStage, root);

        } catch (Exception e) {
        }

        return new Scene(root);
    }
    public void searchChannel() {

        String id = textField.getText();
        HttpResponse<Task1Response> response = task1Client.getSearching(id);
        Task1Response body = response.getBody();
        printsomethink(body);
    }
    public void printsomethink(Task1Response response) {
        for(int i = 0; i < response.items.size(); i++) {
            Task1ActivityItem item = response.items.get(i);
            Label textTitle = new Label(item.snippet.title);
            System.out.println(item.snippet.title);
            textTitle.setTranslateX(29);
            textTitle.setTranslateY(97);

        }
    }

    private Scene Menu(Stage primaryStage, Scene youtube, Scene settings) {
        Pane root = new Pane();
        try {
            root = FXMLLoader.load(getClass().getResource("/start.fxml"));
            buttons(primaryStage, root, youtube, settings);

        } catch (Exception e) {
        }
        return new Scene(root);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        primaryStage.setTitle("Youtube Analytics");
        youtube = initYoutube(primaryStage);
        settings = initSettings(primaryStage);
        menu = Menu(primaryStage, youtube, settings);
        menu.getRoot();
        primaryStage.setScene(menu);
        primaryStage.show();
    }
}
