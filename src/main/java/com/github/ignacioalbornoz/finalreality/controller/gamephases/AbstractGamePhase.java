package com.github.ignacioalbornoz.finalreality.controller.gamephases;

import com.github.ignacioalbornoz.finalreality.controller.FinalRealityController;

import java.util.Objects;

public abstract class AbstractGamePhase implements IGamePhase {

    /**
     * The city that is going to be the context of the state.
     */

    protected FinalRealityController controller;

    /**
     * City's constructor with the common attributes: name and number of inhabitants.
     *
     */
    public AbstractGamePhase() {

        this.controller = null;
    }

    /**
     * Set the city that is the context of the state.
     */
    

    @Override
    public void setController(FinalRealityController controller){
        this.controller = controller;
    }

    public FinalRealityController getController(){
        return this.controller;
    }




    @Override
    public boolean equals(Object o) {
        if (o instanceof IGamePhase) {
            final IGamePhase gamePhase = (IGamePhase) o;
            return getType().equals(gamePhase.getType()) && getController() == gamePhase.getController();
        }
        return false;
    }

    /**
     * Returns the hash code for the name and numbers of inhabitants of this city.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getType(), getController());
    }


}
