package org.springframework.bugs.autowiring;

import java.util.LinkedHashMap;

@SuppressWarnings("rawtypes")
public class CandidateImpl extends LinkedHashMap implements Candidate {
    private static final long serialVersionUID = 2617438257089193692L;
}