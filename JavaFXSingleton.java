import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * How to do a Singleton in JavaFX.
 */
public class JavaFXSingleton
   extends Application
{
   private static JavaFXSingleton cInstance = null;

   public static JavaFXSingleton getInstance()
   {
      return cInstance;
   }

   public JavaFXSingleton()
   {
      super();
      synchronized (JavaFXSingleton.class)
      {
         if (cInstance != null)
         {
            throw new UnsupportedOperationException(
               getClass() +
               " is singleton but constructor called more than once");
         }
         cInstance = this;
      }
   }

   private void init(Stage primaryStage)
   {
      Group root = new Group();
      primaryStage.setScene(new Scene(root));
      VBox box = new VBox(10);
      ImageView imageView = new ImageView("duckling.png");
      Label label = new Label("Rubbber Ducky, You're The One!", imageView);
      label.setContentDisplay(ContentDisplay.TOP);
      box.getChildren().add(label);
      root.getChildren().add(box);
   }

   @Override
   public void start(Stage primaryStage)
      throws Exception
   {
      init(primaryStage);
      primaryStage.show();
   }

   public static void main(String[] args)
   {
      System.out.println(JavaFXSingleton.getInstance());
      launch(args);
      System.out.println(JavaFXSingleton.getInstance());
      new JavaFXSingleton();
   }
}
