package com.example.zzb.aac;

import android.arch.lifecycle.LifecycleFragment;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zzb.aac.databinding.IpFragBinding;
import com.example.zzb.aac.dragger.AppComponent;
import com.example.zzb.aac.dragger.AppModule;
import com.example.zzb.aac.dragger.DaggerAppComponent;
import com.example.zzb.aac.dragger.DaggerFragmentComponet;
import com.example.zzb.aac.dragger.FragmentComponet;
import com.example.zzb.aac.dragger.FragmentModule;
import com.example.zzb.aac.dragger.HasComponent;
import com.example.zzb.aac.net.IpAPI;
import com.example.zzb.aac.repository.IP;
import com.example.zzb.aac.repository.IPDAO;
import com.example.zzb.aac.repository.IPRepository;
import com.example.zzb.aac.repository.MyIPDB;
import com.example.zzb.aac.viewmodle.IPViewModle;

import javax.inject.Inject;

/**
 * Created by zzb on 2017/11/16.
 */

public class IPFragment extends LifecycleFragment {

    IpAPI ipAPI;

    MyIPDB myIPDB;

    IpFragBinding mBinding;

    IPViewModle viewModel;
    Context context;
    FragmentComponet fragmentComponet;

//    @Inject
    IPRepository ipRepository;

    public IPFragment(FragmentComponet fragmentComponet){
        this.fragmentComponet=fragmentComponet;

//        this.getComponent(FragmentComponet.class).appComponent().getMyIPDB();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        fragmentComponet=FragmentComponet().builder()
//                .build();

        fragmentComponet.inject(this);
        ipAPI=fragmentComponet.activity().getAppComponent().getIpAPI();
        myIPDB=fragmentComponet.activity().getAppComponent().getMyIPDB();
        ipRepository=new IPRepository(ipAPI,myIPDB,fragmentComponet.activity().getAppComponent().getContext());
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
        //fragmentComponet.inject(this);
        viewModel = ViewModelProviders.of(this).get(IPViewModle.class);
        viewModel.setIpRepository(ipRepository);
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
//    @SuppressWarnings("unchecked")
//    protected <C> C getComponent(Class<C> componentType) {
//        Log.i("",getActivity().toString());
//        HasComponent<C> ss=(HasComponent<C>)getActivity();
//        C activity=componentType.cast(((HasComponent<C>) getActivity()));
//
//        return componentType.cast(((HasComponent<C>) getActivity() ).getComponent());
//    }
//    public FragmentComponet getComponent() {
////        return DaggerFragmentComponet.builder()
////                .activityModule()
////                .build();
//    }



}
