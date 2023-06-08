package com.example.hellofx;

import com.example.hellofx.models.Station;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class TicketCounterController implements Initializable {
    @FXML
    private GridPane seatGrid;
    @FXML
    private ComboBox<String> dropDownFrom;
    @FXML
    private ComboBox<String> dropDownTo;
    private List<Station> stations;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initStation();
        int cnt = 1;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 6; j++) {
                if (j == 3) continue;
                Button seat = new Button();
                seat.setText(Integer.toString(cnt++));
                seat.setPrefSize(30, 30);
                if (cnt % 3 == 0) {
//                    seat.setStyle("-fx-background-color: red;");
                    seat.setDisable(true);
                } else seat.setStyle("-fx-background-color: lime;");
                GridPane.setConstraints(seat, j - 1, i - 1);
                GridPane.setHalignment(seat, HPos.CENTER);
                GridPane.setValignment(seat, VPos.CENTER);
                seatGrid.getChildren().add(seat);
            }
        }
        for (Node node : seatGrid.getChildren()) {
            if (node instanceof Button button) {
                button.addEventHandler(ActionEvent.ACTION, event -> {
                    if (button.getStyle().equals("-fx-background-color: #fc99ff;")) {
                        button.setStyle("-fx-background-color: lime;");
                    } else {
                        button.setStyle("-fx-background-color: #fc99ff;");
                    }
                });
            }
        }
    }

    private void initStation() {
        String stationSQL = "SELECT * FROM stations ORDER BY station_name ASC";
        try {
            ResultSet resultSet = DBController.statement.executeQuery(stationSQL);
            stations = RowMapper.stationMapper(resultSet);
            for (Station station : stations) {
                dropDownFrom.getItems().add(station.getStation_name());
                dropDownTo.getItems().add(station.getStation_name());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
