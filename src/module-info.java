module SaturnFlora {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens controller to javafx.fxml;
}
