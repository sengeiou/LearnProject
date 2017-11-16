package com.cocoa.runplug

import org.gradle.api.Project
import org.gradle.api.Plugin

public class RunPlug implements Plugin<Project> {
    void apply(Project project) {
            println "123"
    }
}