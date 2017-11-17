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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zzb.aac.databinding.IpFragBinding;
import com.example.zzb.aac.dragger.AppComponent;
import com.example.zzb.aac.dragger.AppModule;
import com.example.zzb.aac.dragger.DaggerAppComponent;
import com.example.zzb.aac.dragger.FragmentComponet;
import com.example.zzb.aac.dragger.HasComponent;
import com.example.zzb.aac.repository.IP;
import com.example.zzb.aac.repository.IPRepository;
import com.example.zzb.aac.viewmodle.IPViewModle;

import javax.inject.Inject;

/**
 * Created by zzb on 2017/11/16.
 */

public class IPFragment extends LifecycleFragment {
    IpFragBinding mBinding;

    IPViewModle viewModel;
    Context context;
//    FragmentComponet fragmentComponet;

//    @Inject
//    IPRepository ipRepository;

    public IPFragment(){
//        ipRepository=getActivity()

    }
//    public IPFragment(Context context){
//        this.context=context;
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(FragmentComponet.class).inject(this);
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
        this.getComponent(FragmentComponet.class).inject(this);
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
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }



}
