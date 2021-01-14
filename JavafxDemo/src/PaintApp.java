import com.sun.prism.BasicStroke;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PaintApp extends Application {
	BorderPane Mainlayout=new BorderPane();
	BorderPane sublayout1=new BorderPane();
	//VBox mainlayout=new VBox();
	//VBox sublayout1=new VBox();
	//BorderPane sublayout2=new BorderPane();
	MenuBar menubar=new MenuBar();
	ColorPicker colour=new ColorPicker();
	ColorPicker colour1=new ColorPicker();
	Slider slider=new Slider();
	Slider slider1=new Slider();
	Canvas canvas=new Canvas();
	GraphicsContext gc= canvas.getGraphicsContext2D();
	Circle circle=new Circle(0,0,0);
	Rectangle rectangle=new Rectangle(0,0,0,0);
	Ellipse ellipse=new Ellipse(0,0,0,0);
	Line line=new Line();
	int outline=1, fill=1;
	char canvascolour='0', shape='d';
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		// Setting value 
		canvas.setWidth(900);
		canvas.setHeight(630);
		gc.setLineWidth(1);
		colour.setValue(Color.BLACK);
		colour1.setValue(Color.BLACK);
		slider.setValue(1);
		//  Slider
		slider.setMin(1);
		slider.setMax(30);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider1.setMin(5);
		slider1.setMax(30);
		slider1.setShowTickMarks(true);
		slider1.setShowTickLabels(true);
	    ///   MENU ITEMS (ADD IN MENU)
		MenuItem menuitem=new MenuItem("Circle");
		menuitem.setOnAction(e -> shape='c');
		MenuItem menuitem1=new MenuItem("Rectangle");
		menuitem1.setOnAction(e -> shape='r');
		MenuItem menuitem2=new MenuItem("Ellipse");
		menuitem2.setOnAction(e -> shape='e');
		MenuItem menuitem10=new MenuItem("Square");
		menuitem10.setOnAction(e -> shape='s');
		MenuItem menuitem11=new MenuItem("Line");
		menuitem11.setOnAction(e -> shape='l');
		MenuItem menuitem3=new MenuItem("Outline present");
		menuitem3.setOnAction(e -> outline=1);
		MenuItem menuitem4=new MenuItem("Outline Colour",colour);
		MenuItem menuitem5=new MenuItem("No Outline");
		menuitem5.setOnAction(e -> outline=0);
		MenuItem menuitem6=new MenuItem("Filled");
		menuitem6.setOnAction(e -> fill=1);
		MenuItem menuitem7=new MenuItem("Fill Colour",colour1);
		MenuItem menuitem8=new MenuItem("Not Filled");
		menuitem8.setOnAction(e -> fill=0);
		MenuItem menuitem9=new MenuItem("Outline Size ",slider);
		MenuItem menuitem12=new MenuItem("Black");
		menuitem12.setOnAction(e -> {
			canvascolour='b';
			setCanvasColour();
		});
		MenuItem menuitem13=new MenuItem("White");
		menuitem13.setOnAction(e -> {
			canvascolour='w';
			setCanvasColour();
		});
		MenuItem menuitem14=new MenuItem("Red");
		menuitem14.setOnAction(e -> {
			canvascolour='r';
			setCanvasColour();
		});
		MenuItem menuitem15=new MenuItem("Blue");
		menuitem15.setOnAction(e -> {
			canvascolour='l';
			setCanvasColour();
		});
		MenuItem menuitem16=new MenuItem("Green");
		menuitem16.setOnAction(e -> {
			canvascolour='g';
			setCanvasColour();
		});
		MenuItem menuitem17=new MenuItem("Gray");
		menuitem17.setOnAction(e -> {
			canvascolour='y';
			setCanvasColour();
		});
		MenuItem menuitem18=new MenuItem("Clear Canvas");
		menuitem18.setOnAction(e -> {
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		});
		MenuItem menuitem19=new MenuItem("Free hand Drawing");
		menuitem19.setOnAction(e -> {
			shape='d';
		});
		MenuItem menuitem20=new MenuItem("Erase");
		menuitem20.setOnAction(e -> {
			shape='x';
		});
		MenuItem menuitem21=new MenuItem("Eraser size",slider1);
		   ////  MENU (ADD IN MENU BAR)
		javafx.scene.control.Menu menu=new javafx.scene.control.Menu("Shapes");  
		javafx.scene.control.Menu menu1=new javafx.scene.control.Menu("Outline");   
		javafx.scene.control.Menu menu2=new javafx.scene.control.Menu("Fill");  
		javafx.scene.control.Menu menu3=new javafx.scene.control.Menu("Outline Size"); 
		javafx.scene.control.Menu menu4=new javafx.scene.control.Menu("Canvas Colours"); 
		javafx.scene.control.Menu menu5=new javafx.scene.control.Menu("Other Options"); 
		javafx.scene.control.Menu menu6=new javafx.scene.control.Menu("Eraser Options"); 
		menu.getItems().addAll(menuitem,menuitem1,menuitem2,menuitem10,menuitem11);
		menu1.getItems().addAll(menuitem4,menuitem5,menuitem3);
		menu2.getItems().addAll(menuitem7,menuitem8,menuitem6);
		menu3.getItems().addAll(menuitem9);
		menu4.getItems().addAll(menuitem12, menuitem13, menuitem14, menuitem15, menuitem16, menuitem17);
		menu5.getItems().addAll(menuitem18,menuitem19);
		menu6.getItems().addAll(menuitem20,menuitem21);
		menubar.getMenus().add(menu);
		menubar.getMenus().add(menu1);
		menubar.getMenus().add(menu2);
		menubar.getMenus().add(menu3);
		menubar.getMenus().add(menu4);
		menubar.getMenus().add(menu6);
		menubar.getMenus().add(menu5);
		Mainlayout.setTop(menubar);
		Text data=new Text();
		data.setText("Shape : Free hand drawing");
		Text axis=new Text();
		sublayout1.setLeft(data);
		sublayout1.setRight(axis);
		Mainlayout.setBottom(sublayout1);
		Mainlayout.setCenter(canvas);
		Mainlayout.setStyle("-fx-background-color: white");
		//mainlayout.getChildren().add(sublayout1);
		//mainlayout.getChildren().add(sublayout2);
		// setting layout of scene
		Scene scene=new Scene(Mainlayout);
		//    stage info  //
		stage.setScene(scene);
		stage.setX(10);
		stage.setY(10);
		stage.setTitle("Paint APP");
		stage.show();
		 //             Styling
		menubar.setStyle("-fx-font: 15 arial;");
		BackgroundFill background_fill = new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		menubar.setBackground(background);
		//
		canvas.setOnMousePressed(e -> {
			axis.setText("X : "+e.getX()+"   Y : "+e.getY());
			if(shape=='c')
			{
				setfill();
				setoutline();
				circle.setCenterX(e.getX());
				circle.setCenterY(e.getY());
				data.setText("Shape : Circle  ");
			}
			else if(shape=='r')
			{
				setfill();
				setoutline();
				rectangle.setX(e.getX());
				rectangle.setY(e.getY());
				data.setText("Shape : Rectangle  ");
			}
			else if(shape=='e')
			{
				setfill();
				setoutline();
				ellipse.setCenterX(e.getX());
				ellipse.setCenterY(e.getY());
				data.setText("Shape : Ecllipse");
			}
			else if(shape=='s')
			{
				setfill();
				setoutline();
				rectangle.setX(e.getX());
				rectangle.setY(e.getY());
				data.setText("Shape : Square");
			}
			else if(shape=='l')
			{
				setfill();
				setoutline();
				line.setStartX(e.getX());
				line.setStartY(e.getY());
				data.setText("Shape : Line");
			}
			else if(shape=='d')
			{
				setfill();
				setoutline();
				gc.beginPath();
				gc.lineTo(e.getX(), e.getY());
				data.setText("Shape : Free hand drawing");
			}
			else if(shape=='x')
			{
				gc.setLineWidth(slider1.getValue());
				gc.clearRect(e.getX(), e.getY(), gc.getLineWidth(), gc.getLineWidth());
				data.setText("Shape : Eraser");
			}
		}
		);
		canvas.setOnMouseDragged(e->{
			axis.setText("X : "+e.getX()+"   Y : "+e.getY());
			if(shape=='d')
			{
				gc.lineTo(e.getX(), e.getY());
				gc.stroke();
			}
			else if(shape=='x')
			{
				gc.clearRect(e.getX(), e.getY(), gc.getLineWidth(), gc.getLineWidth());
			}
		});
		canvas.setOnMouseReleased(e -> {
			axis.setText("X : "+e.getX()+"   Y : "+e.getY());
			if(shape=='c')
			{
				double radius=0;
				if(circle.getCenterX()<e.getX()&&circle.getCenterY()<e.getY())
				{
					radius=(e.getX()-circle.getCenterX())+(e.getY()-circle.getCenterY());
					circle.setCenterX(e.getX());
					circle.setCenterY(e.getY());
				}
				else if(circle.getCenterX()>e.getX()&&circle.getCenterY()>e.getY())
				{
					radius=(circle.getCenterX()-e.getX())+(circle.getCenterY()-e.getY());
					circle.setCenterX(e.getX());
					circle.setCenterY(e.getY());
				}
				else if(circle.getCenterX()>e.getX()&&circle.getCenterY()<e.getY())
				{
					radius=(circle.getCenterX()-e.getX())+(e.getY()-circle.getCenterY());
					circle.setCenterX(e.getX());
					circle.setCenterY(e.getY());
				}
				else if(circle.getCenterX()<e.getX()&&circle.getCenterY()>e.getY())
				{
					radius=(e.getX()-circle.getCenterX())+(circle.getCenterY()-e.getY());
					circle.setCenterX(e.getX());
					circle.setCenterY(e.getY());
				}
				else if(circle.getCenterX()>e.getX()&&circle.getCenterY()>e.getY())
				{
					radius=(circle.getCenterX()-e.getX())+(circle.getCenterY()-e.getY());
					circle.setCenterX(e.getX());
					circle.setCenterY(e.getY());
				}
				circle.setRadius(radius);
				gc.fillOval(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius());
				gc.strokeOval(circle.getCenterX(), circle.getCenterY(), circle.getRadius(), circle.getRadius());
			}
			else if(shape=='r')
			{
				double width=0, length=0;
				if(e.getX()>rectangle.getX() && e.getY()>rectangle.getY())
				{
					width=e.getX()-rectangle.getX();
					length=e.getY()-rectangle.getY();
				}
				else if(e.getX()<rectangle.getX() && e.getY()<rectangle.getY())
				{
					width=rectangle.getX()-e.getX();
					length=rectangle.getY()-e.getY();
				}
				else if(e.getX()<rectangle.getX() && e.getY()>rectangle.getY())
				{
					width=rectangle.getX()-e.getX();
					length=e.getY()-rectangle.getY();
				}
				else if(e.getX()>rectangle.getX() && e.getY()<rectangle.getY())
				{
					width=e.getX()-rectangle.getX();
					length=rectangle.getY()-e.getY();
				}
				rectangle.setWidth(width);
				rectangle.setHeight(length);
				gc.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
				gc.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
			}
			else if(shape=='e')
			{
				double radiusX=0, radiusY=0;
				if(e.getX()>ellipse.getCenterX() && e.getY()>ellipse.getCenterY())
				{
					radiusX=e.getX()-ellipse.getCenterX();
					radiusY=e.getY()-ellipse.getCenterY();
				}
				else if(e.getX()<ellipse.getCenterX() && e.getY()<ellipse.getCenterY())
				{
					radiusX=ellipse.getCenterX()-e.getX();
					radiusY=ellipse.getCenterY()-e.getY();
				}
				else if(e.getX()<ellipse.getCenterX() && e.getY()>ellipse.getCenterY())
				{
					radiusX=ellipse.getCenterX()-e.getX();
					radiusY=e.getY()-ellipse.getCenterY();
				}
				else if(e.getX()>ellipse.getCenterX() && e.getY()<ellipse.getCenterY())
				{
					radiusX=e.getX()-ellipse.getCenterX();
					radiusY=ellipse.getCenterY()-e.getY();
				}
				ellipse.setRadiusX(radiusX);
				ellipse.setRadiusY(radiusY);
				gc.fillOval(ellipse.getCenterX(), ellipse.getCenterY(), ellipse.getRadiusX(), ellipse.getRadiusY());
				gc.strokeOval(ellipse.getCenterX(), ellipse.getCenterY(), ellipse.getRadiusX(), ellipse.getRadiusY());
			}
			else if(shape=='s')
			{
				double width=0, length=0;
				if(e.getX()>rectangle.getX() && e.getY()>rectangle.getY())
				{
					width=e.getX()-rectangle.getX();
					length=width;
				}
				else if(e.getX()<rectangle.getX() && e.getY()<rectangle.getY())
				{
					width=rectangle.getX()-e.getX();
					length=width;
				}
				else if(e.getX()<rectangle.getX() && e.getY()>rectangle.getY())
				{
					width=rectangle.getX()-e.getX();
					length=width;
				}
				else if(e.getX()>rectangle.getX() && e.getY()<rectangle.getY())
				{
					width=e.getX()-rectangle.getX();
					length=width;
				}
				rectangle.setWidth(width);
				rectangle.setHeight(length);
				gc.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
				gc.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
			}
			else if(shape=='l')
			{
				line.setEndX(e.getX());
				line.setEndY(e.getY());
				gc.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
			}
			else if(shape=='d')
			{
				gc.lineTo(e.getX(), e.getY());
				gc.stroke();
				gc.closePath();
			}
			else if(shape=='x')
			{
				gc.clearRect(e.getX(), e.getY(), gc.getLineWidth(), gc.getLineWidth());
			}
		}
		);

	}
	void setfill()
	{
		if(fill==1)
		{
			gc.setFill(colour1.getValue());
		}
		else if(fill==0)
		{
			gc.setFill(Color.TRANSPARENT);
		}
	}
	void setoutline()
	{
		if(outline==1)
		{
			gc.setStroke(colour.getValue());
			gc.setLineWidth(slider.getValue());
		}
		else if(outline==0)
		{
			gc.setStroke(Color.TRANSPARENT);
		}
		
	}
	void setCanvasColour()
	{
		if(canvascolour=='b')
			Mainlayout.setStyle("-fx-background-color: black");
		else if(canvascolour=='w')
			Mainlayout.setStyle("-fx-background-color: white");
		else if(canvascolour=='r')
			Mainlayout.setStyle("-fx-background-color: red");
		else if(canvascolour=='l')
			Mainlayout.setStyle("-fx-background-color: blue");
		else if(canvascolour=='g')
			Mainlayout.setStyle("-fx-background-color: green");
		else if(canvascolour=='y')
			Mainlayout.setStyle("-fx-background-color: gray");

	}
	public static void main(String[] args)
	{
		launch(args);
	}

}
