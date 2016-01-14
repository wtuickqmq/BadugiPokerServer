package io.nadron.extension.variables;

public abstract interface RoomVariable extends UserVariable
{
  public abstract boolean isPrivate();

  public abstract boolean isPersistent();

  public abstract boolean isGlobal();

  public abstract void setPrivate(boolean paramBoolean);

  public abstract void setPersistent(boolean paramBoolean);

  public abstract void setGlobal(boolean paramBoolean);

//  public abstract User getOwner();
//
//  public abstract void setOwner(User paramUser);
}