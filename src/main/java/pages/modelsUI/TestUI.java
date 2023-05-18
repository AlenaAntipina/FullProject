package pages.modelsUI;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TestUI {
    private String testName;
    private String testMethod;
    private String latestTestResult;
    private Timestamp latestTestStartTime;
    private Timestamp latestTestEndTime;
}
