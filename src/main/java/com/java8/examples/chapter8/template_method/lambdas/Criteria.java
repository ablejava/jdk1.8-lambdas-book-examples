package com.java8.examples.chapter8.template_method.lambdas;

import com.java8.examples.chapter8.template_method.ApplicationDenied;

// BEGIN Criteria
public interface Criteria {

    public void check() throws ApplicationDenied;

}
// END Criteria
