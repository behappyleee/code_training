package ch_03;

public class Clean_15 {

	// JUnit 
	public void testMessage() {
		String failure = new ComparisonCompactor(0, "b" , "c").compact("a");
		assertTrue("a expected : <[b]> but was: <[c]>".equals(failure));
	}
	
	public void testStartSame() {
		String failure = new ComparisonCompactor(1, "ab" , "cb").compact(null);
		assertEqual("expected : <b[a]> but was: <c[b]>".equals(failure));
	}
	
	public void testEndSame() {
		String failure = new ComparisonCompactor(1, "ab" , "cb").compact(null);
		assertEqual("expected : <ab> but was: <[c]b>".equals(failure));
	}
	
	public void testSame() {
		String failure = new ComparisonCompactor(1, "ab" , "ab").compact(null);
		assertEqual("expected: <ab> but was: <ab>".equals(failure));
	}
	
	public void testNoContextStartAndEndSame() {
		String failure = new ComparisonCompactor(0, "abc" , "adc").compact(null);
		assertEqual("expected: <a[b]c> but was: <a[d]c>".equals(failure));
	}

	public void testStartAndEndContextWithEllipses() {
		String failure = new ComparisonCompactor(0, "abcde" , "abfde").compact(null);
		assertEqual("expected: <...b[c]d...> but was: <...b[f]d...>".equals(failure));
	}

	
	
	
	
	

	
	
	
}
