package org.duckdns.owly.quarkus_11368.test;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class TestQuarkusSomethingResource {
    @Test
    void testBasic() {
        SomethingResourceTestFunction.main(new String[]{});
    }
}
