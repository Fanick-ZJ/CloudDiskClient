import controller.RequestSender;
import entity.R;
import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public class LoginPane {
    static double x;
    static double y;
    static boolean  isRegisterLabel = false;
    static boolean isLoginLabel = true;

    public Stage getLoginPane(){
        Stage stage = new Stage();
        VBox body = new VBox();
        body.setAlignment(Pos.TOP_CENTER);
        body.setPrefWidth(480);
        body.setPrefHeight(580);
        //顶栏，负责窗口移动等等
        AnchorPane top = new AnchorPane();
        top.setPrefWidth(480);
        top.setPrefHeight(50);
        top.setBackground(new Background(new BackgroundFill(Paint.valueOf("#ffffff00"),new CornerRadii(20),new Insets(0))));

        //最小化按钮
        Button minimizeButton = new Button();
        minimizeButton.setPrefWidth(30);
        minimizeButton.setPrefHeight(30);
        minimizeButton.setId("minimizeButton");
        //添加方块一来实现鼠标移动颜色渐变
        Rectangle miniRectangle = new Rectangle(30,30);
        miniRectangle.setFill(Color.valueOf("#ffffff00"));
        //鼠标移动上去时候的渐变
        FillTransition miniToColor = new FillTransition(Duration.millis(100),miniRectangle,Color.valueOf("#ffffff00"),Color.valueOf("dbdeec"));
        //鼠标移动出去时候的渐变
        FillTransition miniBackColor = new FillTransition(Duration.millis(100),miniRectangle,Color.valueOf("dbdeec"),Color.valueOf("#ffffff00"));
        AnchorPane.setRightAnchor(minimizeButton,50.0);
        AnchorPane.setRightAnchor(miniRectangle,50.0);

        //关闭按钮
        Button closeProjectButton = new Button();
        closeProjectButton.setPrefWidth(50);
        closeProjectButton.setPrefHeight(30);
        closeProjectButton.setId("closeProjectButton");
        //添加方块一来实现鼠标移动颜色渐变
        Rectangle closeRectangle = new Rectangle(50,30);
        closeRectangle.setId("closeRectangle");
        closeRectangle.setFill(Color.valueOf("#ffffff00"));
        //鼠标移动上去时候的渐变
        FillTransition closeToColor = new FillTransition(Duration.millis(300),closeRectangle,Color.valueOf("#ffffff00"),Color.valueOf("ff4500"));
        //鼠标移动出去时候的渐变
        FillTransition closeBackColor = new FillTransition(Duration.millis(300),closeRectangle,Color.valueOf("ff4500"),Color.valueOf("#ffffff00"));
        AnchorPane.setRightAnchor(closeProjectButton,0.0);
        AnchorPane.setRightAnchor(closeRectangle,0.0);

        //图标和LogoPane
        HBox IconAndLogo = new HBox();
        //设置外边距
        VBox.setMargin(IconAndLogo,new Insets(20,0,20,0));
        IconAndLogo.setSpacing(20);
        IconAndLogo.setAlignment(Pos.CENTER);
        Image image = new Image("icon/ProjectIcon.png");
        ImageView icon = new ImageView(image);
        icon.setFitHeight(100);
        icon.setFitWidth(100);
        Label logo = new Label("家庭云盘");

        logo.setId("logo");
        //登录界面
        //注册和登录菜单
        HBox LoginAndRegisterPane = new HBox();
        LoginAndRegisterPane.setAlignment(Pos.CENTER);
        //注册登录主体
        VBox LoRBody=  new VBox();
        LoRBody.setId("LoRBody");
        LoRBody.setPrefSize(280,290);
        //登陆注册选择框
        HBox chooseLoginAndRegister = new HBox();
        VBox.setMargin(chooseLoginAndRegister,new Insets(0,0,0,0));
        Label loginLabel = new Label("登陆");
        Label registerLabel = new Label("注册");
        loginLabel.setPrefSize(150,50);
        registerLabel.setPrefSize(150,50);
        loginLabel.setId("loginLabel");
        registerLabel.setId("registerLabel");
        chooseLoginAndRegister.getChildren().addAll(loginLabel,registerLabel);

        //账号密码输入框
        VBox loginPart = new VBox();
        loginPart.setPadding(new Insets(20));
        loginPart.setSpacing(10);
        loginPart.setId("loginPart");
        TextField laccount = new TextField();
        laccount.setPadding(new Insets(0,0,0,10));
        laccount.setPromptText("请输入账号或邮箱");
        laccount.setPrefHeight(40);
        laccount.setId("account");

        TextField lpassword = new TextField();
        lpassword.setPrefHeight(40);
        lpassword.setId("password");
        lpassword.setPromptText("请输入密码");
        lpassword.setPadding(new Insets(0,0,0,10));

        Button loginButton = new Button("登录");
        loginButton.setId("loginButton");
        loginButton.setAlignment(Pos.CENTER);
        loginButton.setFont(new Font("Microsoft YaHei UI",15));
        loginButton.setPrefSize(LoRBody.getPrefWidth()-20,40);
        Label lerrorLable = new Label("asdasdasd");
        lerrorLable.setId("errorLable");
        loginPart.getChildren().addAll(laccount,lpassword,loginButton,lerrorLable);



        //注册界面
        VBox registerPart = new VBox();
        registerPart.setPadding(new Insets(20));
        registerPart.setSpacing(10);
        registerPart.setId("loginPart");
        TextField raccount = new TextField();
        raccount.setPadding(new Insets(0,0,0,10));
        raccount.setPromptText("请输入账号");
        raccount.setPrefHeight(40);
        raccount.setId("account");

        TextField rpassword = new TextField();
        rpassword.setPrefHeight(40);
        rpassword.setId("password");
        rpassword.setPromptText("请输入密码");
        rpassword.setPadding(new Insets(0,0,0,10));

        Button registerButton = new Button("注册");
        registerButton.setId("loginButton");
        registerButton.setAlignment(Pos.CENTER);
        registerButton.setFont(new Font("Microsoft YaHei UI",15));
        registerButton.setPrefSize(LoRBody.getPrefWidth()-20,40);

        Label rerrorLable = new Label("asdasdasd");
        rerrorLable.setId("rerrorLable");
        registerPart.getChildren().addAll(raccount,rpassword,registerButton,rerrorLable);

        LoRBody.getChildren().addAll(chooseLoginAndRegister,loginPart);
        LoginAndRegisterPane.getChildren().add(LoRBody);
        //登录界面点击事件


        registerLabel.setOnMouseClicked(e->{
            if(!isRegisterLabel){
                LoRBody.getChildren().remove(loginPart);
                LoRBody.getChildren().add(registerPart);
                loginLabel.setStyle("-fx-background-color: #f5f5f6");
                registerLabel.setStyle("-fx-background-color: #ffffff");
                isRegisterLabel = true;
                isLoginLabel = false;
            }
        });
        loginLabel.setOnMouseClicked(e->{
            if(!isLoginLabel){
                LoRBody.getChildren().remove(registerPart);
                LoRBody.getChildren().add(loginPart);
                loginLabel.setStyle("-fx-background-color: #ffffff");
                registerLabel.setStyle("-fx-background-color: #f5f5f6");
                isLoginLabel = true;
                isRegisterLabel = false;
            }
        });

        //按钮事件
        //最小化鼠标移动由透明变灰
       minimizeButton.setOnMouseEntered(e->{
            miniToColor.play();
        });
       //最小化鼠标移走由灰变透明
        minimizeButton.setOnMouseExited(e->{
            miniBackColor.play();
        });
        //最小化窗口
        minimizeButton.setOnMouseClicked(event -> {
            stage.setIconified(true);
            closeBackColor.play();
        });
        //关闭按钮从透明变红
        closeProjectButton.setOnMouseEntered(e->{
            closeToColor.play();

        });
        //关闭按钮从红变透明
        closeProjectButton.setOnMouseExited(e->{
            closeBackColor.play();
        });
        //关闭窗口
        closeProjectButton.setOnMouseClicked(e->{
            System.exit(0);
        });
        Scene scene = new Scene(body);
        stage.setScene(scene);
        new DragListener(stage).enableDrag(top);


        //按钮点击事件
        registerButton.setOnMouseClicked(event -> {
            String url = "http://localhost:8081/cloudedisk/user/accountExist";
            Map<String,String> header = new HashMap<>();
            header.put("Content-Type", "application/json; charset=utf-8");
            Map<String,String> param = new HashMap<>();
            param.put("account",raccount.getText());
            R r = RequestSender.get(url, header, param);
            rerrorLable.setText(r.getMessage());
        }
        );

        //顶部状态栏设置
        //无顶部状态栏
        stage.initStyle(StageStyle.UNDECORATED);
        top.getChildren().addAll(miniRectangle,minimizeButton,closeRectangle,closeProjectButton);
        IconAndLogo.getChildren().addAll(icon,logo);
        body.getChildren().addAll(top,IconAndLogo,LoginAndRegisterPane);

        //样式
        Application.setUserAgentStylesheet(getClass().getResource("css/login.css").toExternalForm());
        Background bodyBG = new Background(new BackgroundFill(Paint.valueOf("eceffe"), new CornerRadii(20), new Insets(0)));
        body.setBackground(bodyBG);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Paint.valueOf("#ffffff00"));
        return stage;
    }
}
