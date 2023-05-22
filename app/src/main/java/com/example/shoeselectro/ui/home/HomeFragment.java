package com.example.shoeselectro.ui.home;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import com.example.shoeselectro.R;
import com.example.shoeselectro.contactanos;
import com.example.shoeselectro.databinding.FragmentHomeBinding;
import com.example.shoeselectro.nosotros;

import org.xmlpull.v1.XmlPullParser;

public class HomeFragment extends Fragment {

    Button btnContactanos, btnQuienes;
    private FragmentHomeBinding binding;

    public View onCreateView( LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //HomeViewModel homeViewModel =
          //      new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);

      //  binding = FragmentHomeBinding.inflate(inflater, container, false);
      //  View root = binding.getRoot();

     //   final TextView textView = binding.textHome;
      //  homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        btnContactanos = view.findViewById(R.id.button);
        btnQuienes = view.findViewById(R.id.button2);


        btnContactanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.nav_host_fragment_content_main, contactanos.newInstance("",""));
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        btnQuienes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.nav_host_fragment_content_main, nosotros.newInstance("",""));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}