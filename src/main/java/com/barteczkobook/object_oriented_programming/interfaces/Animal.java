package com.barteczkobook.object_oriented_programming.interfaces;

abstract class Animal {

    private String name = "without name";

    Animal(){}
    Animal(String name) {
        this.name = name;
    }

    abstract String getType();

    public String getName() {
        return name;
    }

    public void speak(int ... v) {
        int vol = Speakable.QUIET;
        if(v.length == 1) vol = v[0];
        String voice;

        if(this instanceof Speakable)
            voice = ((Speakable)this).getVoice(vol);
        else
            voice = "... (quiet) ...";

        System.out.println(getType() + " " + getName() + " speaks " + voice);
    }

}
