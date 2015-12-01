package org.springframework.issues.spr13733.web;

public final class WitcherResponse {

    private boolean accepted;

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(final boolean accepted) {
        this.accepted = accepted;
    }
}
