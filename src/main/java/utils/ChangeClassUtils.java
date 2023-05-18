package utils;

import data.StatusMap;
import database.dao.StatusDAOImpl;
import database.table.models.Status;
import database.table.models.TestModel;
import lombok.experimental.UtilityClass;
import pages.modelsUI.TestUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class ChangeClassUtils {
    public static List<TestUI> changeTestModelToTestUI(List<TestModel> oldList) {
        List<TestUI> newList = new ArrayList<>();
        oldList.forEach(test -> newList.add(changeTestModelToTestUI(test)));
        return newList;
    }

    public static TestUI changeTestModelToTestUI(TestModel oldTest) {
        return new TestUI(oldTest.getName(), oldTest.getMethodName(), StatusMap.getStatusMap().get(oldTest.getStatusId()), oldTest.getStartTime(), oldTest.getEndTime());
    }

    public static Map<Long, String> changeStatusListToMap() {
        return new StatusDAOImpl().getAll().stream().collect(Collectors.toMap(Status::getId, Status::getName));
    }
}
