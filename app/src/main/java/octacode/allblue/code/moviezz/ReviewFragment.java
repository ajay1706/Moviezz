package octacode.allblue.code.moviezz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import octacode.allblue.code.moviezz.fetchers.FetchReviewTask;

public class ReviewFragment extends Fragment {

    public ReviewFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public static TextView tv_review,tv_author,tv_review_url;
    public static RelativeLayout rl_nothing_progress,rl_noReview;
    public static LinearLayout linear_review;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_review, container, false);
        tv_review=(TextView)rootView.findViewById(R.id.review_tv);
        tv_author = (TextView)rootView.findViewById(R.id.review_author_name);
        tv_review_url = (TextView)rootView.findViewById(R.id.review_url);
        rl_nothing_progress = (RelativeLayout) rootView.findViewById(R.id.loadingPanel);
        rl_noReview = (RelativeLayout)rootView.findViewById(R.id.noText);
        linear_review = (LinearLayout)rootView.findViewById(R.id.linear_layout_review);
        FetchReviewTask fetchReviewTask = new FetchReviewTask(getContext());
        fetchReviewTask.execute(getActivity().getIntent().getStringExtra("MOVIE_ID"));
        return rootView;
    }
}
