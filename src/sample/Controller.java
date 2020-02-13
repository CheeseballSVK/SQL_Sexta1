package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ConnectionClass cn = new ConnectionClass();
    Connection connection = cn.getConnection();
    ObservableList<User> observableList = FXCollections.observableArrayList();

    @FXML
    TableView<User> tableView = new TableView();
    @FXML
    TableColumn<User, String> column_id;
    @FXML
    TableColumn<User, String> column_name;
    @FXML
    TableColumn<User, String> column_surname;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        column_id.setCellValueFactory(new PropertyValueFactory("id"));
        column_name.setCellValueFactory(new PropertyValueFactory("name"));
        column_surname.setCellValueFactory(new PropertyValueFactory("surname"));
        String sql = "select * from user;";
        try {
            Statement statement = connection.createStatement();
            column_id = new TableColumn<>("id");
            column_name = new TableColumn<>("First Name");
            column_surname = new TableColumn<>("Last Name");

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                observableList.add(new User(id, name, surname));
            }


        } catch(SQLException e){
            e.printStackTrace();
        }

        tableView.setItems(observableList);
    }
}
