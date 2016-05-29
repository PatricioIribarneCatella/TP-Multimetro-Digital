package laboratorio.multimetroDigital.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import laboratorio.multimetroDigital.manejadores.BotonVolverEventHandler;
import laboratorio.multimetroDigital.modelo.Multimetro;

public class VistaMultimetro implements Vista {

	private Vista vistaAnterior;
	private Stage stage;
	private Multimetro modelo;
	private Scene escena;
	private BorderPane contenedor;
	private Label medicionVoltimetro;
	private Label medicionAmperimetro;
	private Label medicionOhmetro;

	public VistaMultimetro(Vista vistaAnterior) {
		
		this.modelo = new Multimetro();
		this.vistaAnterior = vistaAnterior;
		this.stage = vistaAnterior.getStage();
		this.initialize();
	}

	private void initialize() {

		this.contenedor = new BorderPane();
		
		this.setContenedorPrincipal();
		
		this.setImagenDeFondo();
		
		this.setCaracteristicasAlContenedorPrincipal();
		
		this.escena = new Scene(this.contenedor, 350, 600);
	}

	private void setImagenDeFondo() {
		// Si le queremos poner una imagen copada de fondo
	}

	private void setContenedorPrincipal() {
		
		this.contenedor.setPadding(new Insets(25));
	}
	
	private void setCaracteristicasAlContenedorCentro() {
		
		GridPane contenedorCentral = new GridPane();
		contenedorCentral.setHgap(15);
		contenedorCentral.setVgap(10);
		contenedorCentral.setPadding(new Insets(25));
		contenedorCentral.setAlignment(Pos.CENTER);
		
		/*Volt�metro*/
		
		Label etiquetaVoltimetro = new Label("Volt�metro (Volt)");
		etiquetaVoltimetro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		etiquetaVoltimetro.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorVoltimetro = new BackgroundFill(Color.GREEN, new CornerRadii(3), new Insets(0.0,0.0,0.0,0.0));
		etiquetaVoltimetro.setBackground(new Background(fondoDeColorVoltimetro));
		
		this.medicionVoltimetro = new Label(this.modelo.getVoltaje());
		this.medicionVoltimetro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		this.medicionVoltimetro.setTextFill(Color.BLACK);
		
		contenedorCentral.add(this.medicionVoltimetro, 1, 0);
		
		contenedorCentral.add(etiquetaVoltimetro, 0, 0);
		
		/*Amper�metro*/
		
		Label etiquetaAmperimetro = new Label("Amper�metro (Ampere)");
		etiquetaAmperimetro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		etiquetaAmperimetro.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorAmperimetro = new BackgroundFill(Color.GREEN, new CornerRadii(3), new Insets(0.0,0.0,0.0,0.0));
		etiquetaAmperimetro.setBackground(new Background(fondoDeColorAmperimetro));
		
		this.medicionAmperimetro = new Label(this.modelo.getAmperaje());
		this.medicionAmperimetro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		this.medicionAmperimetro.setTextFill(Color.BLACK);
		
		contenedorCentral.add(this.medicionAmperimetro, 1, 1);
		
		contenedorCentral.add(etiquetaAmperimetro, 0, 1);
		
		/*Ohmetro*/
		
		Label etiquetaOhmetro = new Label("Ohmetro (Ohm)");
		etiquetaOhmetro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		etiquetaOhmetro.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorOhmetro = new BackgroundFill(Color.GREEN, new CornerRadii(3), new Insets(0.0,0.0,0.0,0.0));
		etiquetaOhmetro.setBackground(new Background(fondoDeColorOhmetro));
		
		this.medicionOhmetro = new Label(this.modelo.getResistencia());
		this.medicionOhmetro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		this.medicionOhmetro.setTextFill(Color.BLACK);
		
		contenedorCentral.add(this.medicionOhmetro, 1, 2);
		
		contenedorCentral.add(etiquetaOhmetro, 0, 2);
		
		this.contenedor.setCenter(contenedorCentral);
	}
	
	private void setCaracteristicasAlContenedorInferior() {
		
		Button botonVolver = new Button("Volver");
		botonVolver.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
		botonVolver.setTextFill(Color.WHITE);
		
		BackgroundFill fondoDeColorVolver = new BackgroundFill(Color.RED, new CornerRadii(5), new Insets(0.0,0.0,0.0,0.0));
		botonVolver.setBackground(new Background(fondoDeColorVolver));
		
		botonVolver.setOnMouseEntered(e -> {
			
			botonVolver.setScaleX(1.2);
			botonVolver.setScaleY(1.2);
		});
		
		botonVolver.setOnMouseExited(e -> {
			
			botonVolver.setScaleX(1);
			botonVolver.setScaleY(1);
		});
		
		botonVolver.setOnAction(new BotonVolverEventHandler(this, this.vistaAnterior));
		
		this.contenedor.setBottom(botonVolver);
	}
	
	private void setCaracteristicasAlContenedorPrincipal() {
		
		this.setCaracteristicasAlContenedorCentro();
		this.setCaracteristicasAlContenedorInferior();
	}

	@Override
	public void mostrar() {
		
		this.stage.setTitle("Mult�metro Digital");
		this.stage.setScene(this.escena);
		this.stage.show();
	}

	@Override
	public Stage getStage() {
		return this.stage;
	}
}