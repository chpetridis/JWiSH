package gr.uoi.cs.JWish.WDG;


public class SliceFragment {
	private final int fragmentStartPosition;
	private final int fragmentLength;
	private final String fragment;
	
	public SliceFragment(String fragment, int fragmentLength, int fragmentStartPosition) {
		this.fragment = fragment;
		this.fragmentLength = fragmentLength;
		this.fragmentStartPosition = fragmentStartPosition;
	}
	
	public int getFragmentLength() {
		return fragmentLength;
	}
	
	public int getFragmentStartPosition() {
		return fragmentStartPosition;
	}
	
	public String getFragment() {
		return fragment;
	}

}
