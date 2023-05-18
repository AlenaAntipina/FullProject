package steps;

import aquality.selenium.core.logging.Logger;
import database.dao.AttachmentDAOImpl;
import database.dao.LogDAOImpl;
import database.dao.ProjectDAOImpl;
import database.dao.TestDAOImpl;
import database.table.models.Attachment;
import database.table.models.Log;
import database.table.models.TestModel;
import lombok.experimental.UtilityClass;
import org.apache.hc.core5.http.ContentType;

import java.util.List;
import java.util.NoSuchElementException;

@UtilityClass
public class DataBaseSteps {
   public static List<TestModel> getTests() {
      Logger.getInstance().info("Step: get tests by Db request");
      return new TestDAOImpl().getAll();
   }

   public long getProjectId(String projectName) {
      Logger.getInstance().info("Step: get project id");
      try {
         return new ProjectDAOImpl().getAll().stream()
                 .filter(project -> project.getName().equals(projectName)).findFirst().get().getId();
      }
      catch (NoSuchElementException e) {
         Logger.getInstance().error("There is no project " + projectName);
         throw new RuntimeException(e);
      }
   }

   public static void addTest(TestModel test, byte[] image, String logs) {
      Logger.getInstance().info("Step: add test");
      new TestDAOImpl().create(test);

      Attachment attachment = new Attachment(image, ContentType.IMAGE_JPEG.getMimeType(), test.getId());
      new AttachmentDAOImpl().create(attachment);

      Log log = new Log(logs, false, test.getId());
      new LogDAOImpl().create(log);
   }
}
