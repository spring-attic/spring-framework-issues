package org.springframework.issues.service;

import org.springframework.issues.generic.ChildGeneric;
import org.springframework.stereotype.Service;

@Service
public class ChildService extends ParentService<ChildGeneric> {

}
