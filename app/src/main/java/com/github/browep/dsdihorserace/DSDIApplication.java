package com.github.browep.dsdihorserace;

import android.app.Application;

import com.github.browep.dsdi.DependencySupplier;

/**
 * Created by paulbrower on 4/8/18.
 */

public class DSDIApplication extends Application implements DependencySupplier.CanInject{

    public DependencySupplier dependencySupplier;

    @Override
    public void onCreate() {
        super.onCreate();

        dependencySupplier = new DependencySupplier();
    }

    @Override
    public void inject(Object obj) {
        dependencySupplier.inject(obj);
    }

    public class DependencySupplier extends com.github.browep.dsdi.DependencySupplier {

        public final NetworkFacade networkFacade;
        public final DataFacade dataFacade;

        public DependencySupplier() {
            networkFacade = new NetworkFacade();
            dataFacade = new DataFacade();

        }

        @Override
        public Object supply(Object injectee, Class injectionClass) throws IllegalArgumentException {
            if (injectionClass.equals(NetworkFacade.class)) {
                return networkFacade;
            } else if (injectionClass.equals(DataFacade.class)) {
                return dataFacade;
            } else {
                throw new IllegalArgumentException("cant supply: " + injectionClass);
            }
        }
    }

    public class NetworkFacade {

    }

    public class DataFacade {

    }
}
