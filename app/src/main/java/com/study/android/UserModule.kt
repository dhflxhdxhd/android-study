package com.study.android

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class UserModule {

//    @UserQualifier(20,133)
//    @Provides
//    fun provideUser1():User{
//        return User("초코라떼")
//    }
//
//    @UserQualifier(50,163)
//    @Provides
//    fun provideUser2():User{
//        return User("솔트크림")
//    }

    @Named("cl")
    @Provides
    fun provideUser1():User{
        return User("초코라떼")
    }

    @Named("sc")
    @Provides
    fun provideUser2():User{
        return User("솔트크림")
    }
}