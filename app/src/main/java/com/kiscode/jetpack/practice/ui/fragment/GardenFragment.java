package com.kiscode.jetpack.practice.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.kiscode.jetpack.practice.data.pojo.FavoritePlant;
import com.kiscode.jetpack.practice.data.pojo.Plant;
import com.kiscode.jetpack.practice.databinding.FragmentGardenBinding;
import com.kiscode.jetpack.practice.ui.adapter.PlantListAdapter;
import com.kiscode.jetpack.practice.viewmodels.GardenViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Description:
 * Author: keno
 * Date : 2021/3/16 14:46
 **/
public class GardenFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentGardenBinding binding = FragmentGardenBinding.inflate(inflater, container, false);

//        View rootView = inflater.inflate(R.layout.fragment_garden, container, false);
        PlantListAdapter adapter = new PlantListAdapter(Collections.<Plant>emptyList());
        binding.recyclerviewGarden.setAdapter(adapter);

        subScribeUi(binding, adapter);

        return binding.getRoot();
    }

    private void subScribeUi(final FragmentGardenBinding binding, final PlantListAdapter adapter) {
        //初始化ViewModel
        GardenViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(GardenViewModel.class);

        viewModel.favoritePlantsLiveData.observe(getViewLifecycleOwner(), new Observer<List<FavoritePlant>>() {
            @Override
            public void onChanged(List<FavoritePlant> plants) {
                Log.i("onChanged", "onChanged:" + plants.size());
//                adapter.setNewDatas(plants);
//                binding.setHasPlantings(plants!=null && !plants.isEmpty());
            }
        });
    }
}