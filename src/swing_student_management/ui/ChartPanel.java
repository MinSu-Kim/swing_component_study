package swing_student_management.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.paint.Color;
import swing_student_management.dto.Student;

@SuppressWarnings("serial")
public class ChartPanel extends JPanel {
	private BarChart<String, Number> barChart;
	private List<Student> stdLists;

	public ChartPanel() {
		setLayout(new BorderLayout(0, 0));

		JFXPanel fxPanel = new JFXPanel();
		fxPanel.setBorder(new TitledBorder(null, "차트", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(fxPanel);

		Platform.runLater(() -> initFX(fxPanel));
	}

	private void initFX(JFXPanel fxPanel) {
		Scene scene = createScene();
		fxPanel.setScene(scene);
	}

	private Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500, Color.ALICEBLUE);

		// 막 대형 차트의 X 축과 Y 축을 정의하고 레이블을 설정
		CategoryAxis xAxis = new CategoryAxis();
//		xAxis.setLabel("과목");

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("점수");

		barChart = new BarChart<>(xAxis, yAxis);
		barChart.setTitle("학생별 점수");
		barChart.setLegendSide(Side.BOTTOM);
		barChart.setPrefSize(450, 450);
		getBarChartData(null);
		
		root.getChildren().add(barChart);

		return scene;
	}

	public void setStdLists(List<Student> stdLists) {
		this.stdLists = stdLists;
	}

	public BarChart<String, Number> getBarChart() {
		return barChart;
	}
	
	public void changeChartData(Student std) {
		XYChart.Series<String, Number> datas = getBarChartData(std);
		barChart.getData().clear();
		barChart.getData().add(datas);
	}
	
	public void loadAllChartData() {
		Platform.runLater(() -> {
			barChart.getData().clear();
			barChart.getData().addAll(getAllData());
		});
	}

	public List<XYChart.Series<String, Number>> getAllData() {
		List<XYChart.Series<String, Number>> lists = new ArrayList<>();
		for (Student std : stdLists) {
			lists.add(getBarChartData(std));
		}
		return lists;
	}

	public XYChart.Series<String, Number> getBarChartData(Student std) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		if (std==null) {
			dataSeries.setName("학생명");
			dataSeries.getData().add(new XYChart.Data<>(StudentManagementUI.KOR, 0));
			dataSeries.getData().add(new XYChart.Data<>(StudentManagementUI.ENG, 0));
			dataSeries.getData().add(new XYChart.Data<>(StudentManagementUI.MATH, 0));
			return dataSeries;
		}
		dataSeries.setName(std.getStdName());
		dataSeries.getData().add(new XYChart.Data<>(StudentManagementUI.KOR, std.getKorScore()));
		dataSeries.getData().add(new XYChart.Data<>(StudentManagementUI.ENG, std.getEngScore()));
		dataSeries.getData().add(new XYChart.Data<>(StudentManagementUI.MATH, std.getMathScore()));
		return dataSeries;
	}
}
