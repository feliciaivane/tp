package seedu.address;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import javafx.application.Application;
import seedu.address.logic.parser.CompleteCommandParserTest;
import seedu.address.model.Internship;

public class AppParametersTest {

    private final ParametersStub parametersStub = new ParametersStub();
    private final AppParameters expected = new AppParameters();

    @Test
    public void parse_validConfigPath_success() {
        parametersStub.namedParameters.put("config", "config.json");
        expected.setConfigPath(Paths.get("config.json"));
        assertEquals(expected, AppParameters.parse(parametersStub));
    }

    @Test
    public void parse_nullConfigPath_success() {
        parametersStub.namedParameters.put("config", null);
        assertEquals(expected, AppParameters.parse(parametersStub));
    }

    @Test
    public void parse_invalidConfigPath_success() {
        parametersStub.namedParameters.put("config", "a\0");
        expected.setConfigPath(null);
        assertEquals(expected, AppParameters.parse(parametersStub));
    }

    @Test
    public void equals() {
        // same object -> return true
        assertTrue(expected.equals(expected));

        // null -> return false
        assertFalse(expected.equals(null));

        // not app parameters -> return false
        assertFalse(expected.equals(new Internship()));
    }

    private static class ParametersStub extends Application.Parameters {
        private Map<String, String> namedParameters = new HashMap<>();

        @Override
        public List<String> getRaw() {
            throw new AssertionError("should not be called");
        }

        @Override
        public List<String> getUnnamed() {
            throw new AssertionError("should not be called");
        }

        @Override
        public Map<String, String> getNamed() {
            return Collections.unmodifiableMap(namedParameters);
        }
    }
}
