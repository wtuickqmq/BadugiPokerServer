package io.nadron.client.event;

public interface Event
{
	int getType();

	void setType(int type);

	Object getSource();

	void setSource(Object source);

	long getTimeStamp();

	void setTimeStamp(long timeStamp);
}
