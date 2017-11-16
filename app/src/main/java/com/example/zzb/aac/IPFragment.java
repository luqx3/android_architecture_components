package com.example.zzb.aac;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zzb.aac.databinding.IpFragBinding;
import com.example.zzb.aac.repository.IP;
import com.example.zzb.aac.repository.IPRepository;
import com.example.zzb.aac.viewmodle.IPViewModle;

/**
 * Created by zzb on 2017/11/16.
 */

public class IPFragment extends LifecycleFragment {
    IpFragBinding mBinding;
    IPRepository ipRepository;
    IPViewModle viewModel;
    Context context;
    public IPFragment(){

    }
    public IPFragment(Context context){
        this.context=context;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.ip_frag, container, false);
        return mBinding.getRoot();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(IPViewModle.class);
        viewModel.setContext(context);
        subscribeUi(viewModel);
        mBinding.setViewmodle(viewModel);

    }

    private void subscribeUi(IPViewModle viewModel){
            viewModel.getip().observe(this, new Observer<IP>() {
            @Override
            public void onChanged(IP ip) {
                if(ip!=null) {
                    mBinding.tv.setText(ip.getCountry() == null ? "" : ip.getCountry());
                }
            }
        });
    }
}
