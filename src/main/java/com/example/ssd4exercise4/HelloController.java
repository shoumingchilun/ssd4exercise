package com.example.ssd4exercise4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HelloController {
    @FXML
    private RadioButton AM;

    @FXML
    private Button Apply;

    @FXML
    private CheckBox AutoAdjust;

    @FXML
    private TableView<RowDate> Calendar;

    @FXML
    private Button Cancel;

    @FXML
    private Label CurrentZone;

    @FXML
    private Spinner<Integer> Hour;

    @FXML
    private Spinner<Integer> Minute;

    @FXML
    private ChoiceBox<String> Month;

    @FXML
    private Button OK;

    @FXML
    private RadioButton PM;

    @FXML
    private Spinner<Integer> Second;

    @FXML
    private ChoiceBox<String> TimeZone;

    @FXML
    private Spinner<Integer> Year;

    @FXML
    private ImageView ZoneView;

    @FXML
    private Group Group_SHAPE;

    private boolean isAdjust = false;
    private int oldZone = 8;
    private int notOldZone = 8;

    @FXML
    void Apply(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Report.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 300, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Report");
        stage.setScene(scene);
        ReportController controller = fxmlLoader.getController();
        controller.init(
                "Apply\n" +
                        "====================\n" +
                        "Year = " + Year.getValue() + "\n" +
                        "Month = " + Month.getValue() + "\n" +
                        "Day = " + java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH) + "\n" +
                        (AM.isSelected() ? "AM" : "PM") + "Hour = " + Hour.getValue()+"\n" +
                        "Minute = "+Minute.getValue()+"\n" +
                        "Second = "+Second.getValue()+"\n" +
                        "TimeZone = "+TimeZone.getValue()+"\n" +
                        "Auto adjust = "+(AutoAdjust.isSelected()?"True":"False")+"\n" +
                        "====================\n" +
                        "(Time saved)"
        );
        stage.show();
    }

    @FXML
    void Cancel(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Report.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 300, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Report");
        stage.setScene(scene);
        ReportController controller = fxmlLoader.getController();
        controller.init(
                "Cancel\n" +
                        "====================\n" +
                        "Year = " + Year.getValue() + "\n" +
                        "Month = " + Month.getValue() + "\n" +
                        "Day = " + java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH) + "\n" +
                        (AM.isSelected() ? "AM" : "PM") + "Hour = " + Hour.getValue()+"\n" +
                        "Minute = "+Minute.getValue()+"\n" +
                        "Second = "+Second.getValue()+"\n" +
                        "TimeZone = "+TimeZone.getValue()+"\n" +
                        "Auto adjust = "+(AutoAdjust.isSelected()?"True":"False")+"\n" +
                        "====================\n" +
                        "(Time not saved)"
        );
        stage.show();
    }

    @FXML
    void OK(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Report.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 300, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Report");
        stage.setScene(scene);
        ReportController controller = fxmlLoader.getController();
        controller.init(
                "OK\n" +
                        "====================\n" +
                        "Year = " + Year.getValue() + "\n" +
                        "Month = " + Month.getValue() + "\n" +
                        "Day = " + java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH) + "\n" +
                        (AM.isSelected() ? "AM" : "PM") + "Hour = " + Hour.getValue()+"\n" +
                        "Minute = "+Minute.getValue()+"\n" +
                        "Second = "+Second.getValue()+"\n" +
                        "TimeZone = "+TimeZone.getValue()+"\n" +
                        "Auto adjust = "+(AutoAdjust.isSelected()?"True":"False")+"\n" +
                        "====================\n" +
                        "(Time saved)"
        );
        stage.show();
    }

    public void init() {
        ToggleGroup toggleGroup = new ToggleGroup();
        AM.setToggleGroup(toggleGroup);
        PM.setToggleGroup(toggleGroup);
        java.util.Calendar calendar = java.util.Calendar.getInstance();


        //初始化月份
        Month.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        Month.getSelectionModel().select(calendar.get(java.util.Calendar.MONTH));

        //初始化年份
        Year.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1900, 2100, calendar.get(java.util.Calendar.YEAR), 1));

        //初始化日历
        Calendar.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("SUN"));
        Calendar.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("MON"));
        Calendar.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("TUE"));
        Calendar.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("WED"));
        Calendar.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("THU"));
        Calendar.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("FRI"));
        Calendar.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("SAT"));
        updateCalendar(calendar.get(java.util.Calendar.MONTH), calendar.get(java.util.Calendar.YEAR));

        //月份更变监听
        Month.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                updateCalendar(Month.getSelectionModel().getSelectedIndex(), Year.getValue());
            }
        });


        //初始化时间
        Hour.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 13, exchangeHourWithDay(calendar.get(java.util.Calendar.HOUR_OF_DAY)), 1));
        Minute.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-1, 60, calendar.get(java.util.Calendar.MINUTE), 1));
        Second.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-1, 60, calendar.get(java.util.Calendar.SECOND), 1));

        //初始化时区列表
        TimeZone.getItems().clear();
        TimeZone.getItems().addAll("UTC/GMT", "UTC+1", "UTC+2", "UTC+3", "UTC+4", "UTC+5", "UTC+6", "UTC+7", "UTC+8", "UTC+9", "UTC+10", "UTC+11", "UTC+12",//0-12对应utc+0-12
                "UTC-1", "UTC-2", "UTC-3", "UTC-4", "UTC-5", "UTC-6", "UTC-7", "UTC-8", "UTC-9", "UTC-10", "UTC-11", "UTC-12");//13-24对应西1-12区
        TimeZone.getSelectionModel().select(8);
        CurrentZone.setText("Current Time Zone : UTC+8");

        //初始化时区图片
        ZoneView.setImage(new Image(HelloController.class.getResource("image0.png").toExternalForm()));
        Group_SHAPE.getChildren().clear();
        Polygon polygon = createTriangle(8);
        Group_SHAPE.getChildren().add(polygon);

        //时区更变监听
        TimeZone.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                Group_SHAPE.getChildren().clear();
                Polygon polygon = createTriangle(TimeZone.getSelectionModel().getSelectedIndex());
                Group_SHAPE.getChildren().add(polygon);
                oldZone = notOldZone;
                notOldZone = TimeZone.getSelectionModel().getSelectedIndex();
                if (isAdjust) {
                    updateZone();
                }
            }
        });

        //监听是否自动更新
        AutoAdjust.selectedProperty().addListener((ObservableValue<? extends Boolean> ov,
                                                   Boolean old_val, Boolean new_val) -> {
            if (AutoAdjust.isSelected()) {
                isAdjust = true;
                updateZone();
            } else {
                isAdjust = false;
            }
        });
    }

    private void updateZone() {
        //获得时区变化后hour需要变化的量
        int tempNew = notOldZone;
        int tempOld = oldZone;
        if (notOldZone > 12) {
            tempNew = -notOldZone + 12;
        }
        if (oldZone > 12) {
            tempOld = -oldZone + 12;
        }
        int change = notOldZone - oldZone;
        //进行变换
        if (isAdjust) {
            int i = Hour.getValue() + change;
            if (i > 12) {
                Hour.getValueFactory().setValue(i - 12);
                if (AM.isSelected()) {
                    PM.fire();
                } else {
                    AM.fire();
                }
            } else if (i < 1) {
                Hour.getValueFactory().setValue(i + 12);
                if (AM.isSelected()) {
                    PM.fire();
                } else {
                    AM.fire();
                }
            } else {
                Hour.getValueFactory().setValue(i);
            }
        }
    }

    private Polygon createTriangle(int i) {
        Polygon polygon = new Polygon();
        if (i < 13 || i == 24) {
            if (i == 24) i = 12;
            polygon.getPoints().addAll(
                    200.0 + (i - 1) * 16.6, 0.0,
                    200.0 + (i - 1) * 16.6 - 8.4, 20.0,
                    200.0 + (i - 1) * 16.6 + 8.4, 20.0);//一个时区宽17
        } else {//13-23在左边
            i -= 12;
            polygon.getPoints().addAll(
                    200.0 - (i + 1) * 16.6, 0.0,
                    200.0 - (i + 1) * 16.6 - 8.4, 20.0,
                    200.0 - (i + 1) * 16.6 + 8.4, 20.0);//一个时区宽17
        }
        return polygon;
    }

    int beforeHour = -1;

    public void HourChange(MouseEvent mouseEvent) {
        if (Hour.getValue() == 12) {//从11进入12，改变AM/PM；从1进入12，不改变AM/PM
            if (beforeHour == 11) {
                if (AM.isSelected()) {
                    PM.fire();
                } else {
                    AM.fire();
                }
            }
        } else if (Hour.getValue() == 13) {
            Hour.getValueFactory().setValue(1);
        } else if (Hour.getValue() == 0) {
            Hour.getValueFactory().setValue(12);
        } else if (Hour.getValue() == 11) {//从12进入11，改变AM/PM；从10进入11，不改变AM/PM
            if (beforeHour == 12) {
                if (AM.isSelected()) {
                    PM.fire();
                } else {
                    AM.fire();
                }
            }
        }
        beforeHour = Hour.getValue();
    }

    public void MinuteChange(MouseEvent mouseEvent) {
        if (Minute.getValue() == -1) {
            Minute.getValueFactory().setValue(59);
            ChangeHour(false);
        } else if (Minute.getValue() == 60) {
            Minute.getValueFactory().setValue(0);
            ChangeHour(true);
        }
    }

    public void SecondChange(MouseEvent mouseEvent) {
        if (Second.getValue() == -1) {
            Second.getValueFactory().setValue(59);
            ChangeMinute(false);
        } else if (Second.getValue() == 60) {
            Second.getValueFactory().setValue(0);
            ChangeMinute(true);
        }
    }

    void ChangeMinute(boolean added) {
        if (added) {
            Minute.getValueFactory().setValue(Minute.getValue() + 1);
            MinuteChange(null);
        } else {
            Minute.getValueFactory().setValue(Minute.getValue() - 1);
            MinuteChange(null);
        }
    }

    void ChangeHour(boolean added) {
        if (added) {
            Hour.getValueFactory().setValue(Hour.getValue() + 1);
            HourChange(null);
        } else {
            Hour.getValueFactory().setValue(Hour.getValue() - 1);
            HourChange(null);
        }
    }

    int exchangeHourWithDay(int Hour) {
        if (Hour < 12) {//1-11
            AM.fire();
            return Hour;
        } else if (Hour == 12) {
            PM.fire();
            return Hour;
        } else if (Hour == 0) {
            AM.fire();
            return 12;
        } else {//13-23
            PM.fire();
            return Hour - 12;
        }
    }

    void updateCalendar(int month, int year) {
        Calendar.getItems().clear();
        for (RowDate row : getRowDateList(month, year)) {
            Calendar.getItems().add(row);
        }
    }

    List<RowDate> getRowDateList(int month, int year) {//输入的month为0-11
        month++;
        List<RowDate> list = new ArrayList<>();
        int allDay = 1;
        for (int i = 1900; i < year; i++) {
            allDay += (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) ? 366 : 365;
        }
        int monthday = 0;
        for (int i = 1; i <= month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    monthday = 31;
                    if (i < month) {
                        allDay += monthday;
                    }
                    break;
                case 2:
                    monthday = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
                    if (i < month) {
                        allDay += monthday;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    monthday = 30;
                    if (i < month) {
                        allDay += monthday;
                    }
                    break;
            }
        }
        int weekDay = allDay % 7;//weekDay是几，就是这个月一号是周几，周日是7，就是0
        RowDate rowDate1 = new RowDate();
        int index = weekDay;
        for (int i = 1; i <= monthday; i++) {
            index = (i + weekDay - 1) % 7;
            rowDate1.data[index] = String.valueOf(i);
            if (index == 6) {
                rowDate1.update();
                list.add(rowDate1);
                rowDate1 = new RowDate();
            }
        }
        if (index != 6) {
            rowDate1.update();
            list.add(rowDate1);
        }
        return list;
    }


    public void YearChanged(MouseEvent mouseEvent) {
        updateCalendar(Month.getSelectionModel().getSelectedIndex(), Year.getValue());
    }

    public void YearChanged2(KeyEvent keyEvent) {
        updateCalendar(Month.getSelectionModel().getSelectedIndex(), Year.getValue());
    }

    public void PageChange(Event event) {
        if (TimeZone != null)
            CurrentZone.setText("Current Time Zone : " + TimeZone.getSelectionModel().getSelectedItem());
    }
}