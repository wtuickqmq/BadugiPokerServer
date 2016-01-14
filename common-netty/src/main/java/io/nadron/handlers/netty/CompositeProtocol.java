package io.nadron.handlers.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelPipeline;

import java.util.List;

public  class CompositeProtocol implements LoginProtocol
{
	private List<LoginProtocol> protocols;

	@Override
	public boolean applyProtocol(ByteBuf buffer,
			ChannelPipeline pipeline)
	{
		if (null != protocols)
		{
			for (LoginProtocol protocol : protocols)
			{
				if (protocol.applyProtocol(buffer, pipeline))
				{
					return true;
				}
			}
		}
		return false;
	}

	public List<LoginProtocol> getProtocols()
	{
		return protocols;
	}

	public void setProtocols(List<LoginProtocol> protocols)
	{
		this.protocols = protocols;
	}
}