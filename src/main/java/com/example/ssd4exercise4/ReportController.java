package com.example.ssd4exercise4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * @auther 齿轮
 * @create 2022-12-25-11:20
 */
public class ReportController {
    @FXML
    private Button OK;

    @FXML
    private TextArea Report;

    @FXML
    void end(ActionEvent event) {
        System.exit(0);
    }

    public void init(String s){
        Report.setText(s);
    }
}
