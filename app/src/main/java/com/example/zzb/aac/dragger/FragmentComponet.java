package com.example.zzb.aac.dragger;

import com.example.zzb.aac.IPFragment;

import dagger.Component;

/**
 * Created by zzb on 2017/11/17.
 */
@ActivityScope
@Component(modules ={ActivityModule.class,FragmentModule.class})
public interface FragmentComponet extends ActivityComponent{
    void inject(IPFragment fragment);
}
