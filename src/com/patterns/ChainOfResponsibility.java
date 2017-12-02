package com.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ihar Zharykau
 */
public class ChainOfResponsibility {
    public static void main(String... args){
        Pipeline pipeline = new Pipeline();
        pipeline.run();
    }
}


interface SampleProcessor{
    void process();
}

class Pipeline{
    private List<SampleProcessor> processors;

    public Pipeline() {
        init();
    }

    private void init(){
        processors = new ArrayList<>();
        processors.add(new ProcessorOne());
        processors.add(new ProcessorTwo());
    }

    public void run(){
        processors.forEach(SampleProcessor::process);
    }
}

class ProcessorOne implements SampleProcessor{

    @Override
    public void process() {
        System.out.println("processor one");
    }
}

class ProcessorTwo implements SampleProcessor{

    @Override
    public void process() {
        System.out.println("processor second");
    }
}