package water;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import water.util.JProfile;
import water.util.Log;

public class NetworkTestTest extends TestUtil {
  public NetworkTestTest() { super(3); }

  @Test public void testNetworkTest() {
    NetworkTest nt = new NetworkTest();
    nt.execImpl();
    nt.toHTML(new StringBuilder());
    StringBuilder sb = new StringBuilder();
    nt.toASCII(sb);
    Log.info(sb);
    assertEquals(nt.nodes.length,H2O.CLOUD.size());
    assertTrue(nt.bandwidths.length == nt.msg_sizes.length);
    assertTrue(nt.microseconds.length == nt.msg_sizes.length);
    assertTrue(nt.bandwidths_collective.length == nt.msg_sizes.length);
    assertTrue(nt.microseconds_collective.length == nt.msg_sizes.length);
    for (int m=0; m<nt.msg_sizes.length; ++m) {
      for (int j=0; j<H2O.CLOUD.size(); ++j) {
        assertTrue(nt.bandwidths[m].length == H2O.CLOUD.size());
        assertTrue(nt.microseconds[m].length == H2O.CLOUD.size());
      }
    }
  }
}