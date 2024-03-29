package com.kiscode.paging.viewmodel;


import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.kiscode.paging.comman.LoadStatus;
import com.kiscode.paging.model.datasoure.UserDataSoureFactory;
import com.kiscode.paging.model.pojo.User;

/****
 * Description: 
 * Author:  keno
 * CreateDate: 2021/4/8 21:32
 */

public class UserViewModel extends ViewModel {
    public final LiveData<PagedList<User>> pagedListLiveData;
    public final LiveData<LoadStatus> loadStatusLiveData;
    private final UserDataSoureFactory factory;


    public UserViewModel() {
        factory = new UserDataSoureFactory();
        pagedListLiveData = new LivePagedListBuilder<>(factory, 100).build();

        loadStatusLiveData = Transformations.switchMap(factory.userDataSoureLiveData, input -> input.loadStatusLiveData);
    }


    public void retry() {
        factory.userDataSoureLiveData.getValue().retry();
    }

    public void resetQuery() {
        factory.userDataSoureLiveData.getValue().resetQuery();
    }
}
