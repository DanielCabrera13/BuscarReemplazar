package dad.buscaryreemp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscaryReemplazar extends Application {
		
		//vistas
		private TextField buscarText;
		private TextField reempText;
		private CheckBox mayus;
		private CheckBox buscarAtras;
		private CheckBox expr;
		private CheckBox resaltar;
		private Button buscarButton;
		private Button reempButton;
		private Button reempAllButton;
		private Button cerrarButton;
		private Button ayudaButton;

		@Override
		public void start(Stage primaryStage) throws Exception {
			
			buscarText = new TextField();
			
			reempText = new TextField();
			
			mayus = new CheckBox("Mayúsculas y minúsculas");
			buscarAtras = new CheckBox("Buscar hacia atrás");
			expr = new CheckBox("Expresión regular");
			resaltar = new CheckBox("Resultar resultados");
			
			buscarButton = new Button("Buscar");
			buscarButton.setMaxWidth(Double.MAX_VALUE);
			
			reempButton = new Button("Reemplazar");
			reempButton.setMaxWidth(Double.MAX_VALUE);
			
			reempAllButton = new Button("Reemplazar todo");
			reempAllButton.setMaxWidth(Double.MAX_VALUE);
			
			cerrarButton = new Button("Cerrar");
			cerrarButton.setMaxWidth(Double.MAX_VALUE);
			
			ayudaButton = new Button("Ayuda");
			ayudaButton.setMaxWidth(Double.MAX_VALUE);
			
			//CAJA CON BOTONES PANEL IZQUIERDO
			VBox cajaBotones = new VBox();
			cajaBotones.setPadding(new Insets(5));
			VBox.setMargin(buscarButton,new Insets(2));
			VBox.setMargin(reempButton,new Insets(2));
			VBox.setMargin(reempAllButton,new Insets(2));
			VBox.setMargin(cerrarButton,new Insets(2));
			VBox.setMargin(ayudaButton,new Insets(2));
			cajaBotones.getChildren().addAll(buscarButton, reempButton, reempAllButton, cerrarButton, ayudaButton);
			
			//PANEL GRID PARA LOS CHECKBOX
			GridPane miniPane = new GridPane();
			miniPane.setPadding(new Insets(5));
			miniPane.setHgap(5);
			miniPane.setVgap(5);
			miniPane.addRow(0);
			miniPane.addRow(1);
			miniPane.add(mayus, 0, 0);
			miniPane.add(buscarAtras, 1, 0);
			miniPane.add(expr, 0,1);
			miniPane.add(resaltar, 1, 1);
			
			ColumnConstraints[] cols1 = { new ColumnConstraints(), new ColumnConstraints()};
			miniPane.getColumnConstraints().setAll(cols1);
			
			RowConstraints[] rows1 = { new RowConstraints(), new RowConstraints()};
			miniPane.getRowConstraints().setAll(rows1);
			
			
			//PANEL GRID GENERAL
			GridPane formPane = new GridPane();
			formPane.setPadding(new Insets(5));
			formPane.setHgap(5);
			formPane.setVgap(5);
			formPane.addRow(0, new Label("Buscar:"), buscarText);
			formPane.addRow(1, new Label("Reemplazar con:"), reempText);
			formPane.addRow(2);
			formPane.add(miniPane, 1, 2);
			
			
			ColumnConstraints[] cols2 = { new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints()};
			formPane.getColumnConstraints().setAll(cols2);
			
			RowConstraints[] rows2 = { new RowConstraints(), new RowConstraints(), new RowConstraints(),
					new RowConstraints()};
			formPane.getRowConstraints().setAll(rows2);
			
			//RESTRICCIONES PANEL GRID GENERAL
			cols2[0].setHgrow(Priority.NEVER);
			cols2[1].setHgrow(Priority.ALWAYS);
			
			GridPane.setColumnSpan(buscarText, 2);
			GridPane.setColumnSpan(reempText, 2);
			
			
			//PANEL GENERAL, CONTENEDOR DEL GRID Y DEL VBOX
			BorderPane root = new BorderPane();
			root.setPadding(new Insets(5));
			root.setCenter(formPane);
			root.setRight(cajaBotones);

			Scene scene = new Scene(root, 640, 480);

			primaryStage.setTitle("GridPaneSample");
			primaryStage.setScene(scene);
			primaryStage.show();
			

		}

		public static void main(String[] args) {
			launch(args);

		}

	}
