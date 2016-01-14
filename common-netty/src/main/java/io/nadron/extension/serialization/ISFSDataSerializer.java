package io.nadron.extension.serialization;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import io.nadron.extension.data.ISFSArray;
import io.nadron.extension.data.ISFSObject;
import io.nadron.extension.data.SFSArray;
import io.nadron.extension.data.SFSObject;

public abstract interface ISFSDataSerializer {
	
	public abstract byte[] object2binary(ISFSObject paramISFSObject);

	public abstract byte[] array2binary(ISFSArray paramISFSArray);

	public abstract ISFSObject binary2object(byte[] paramArrayOfByte);

	public abstract ISFSArray binary2array(byte[] paramArrayOfByte);

	public abstract String object2json(Map<String, Object> paramMap);

	public abstract String array2json(List<Object> paramList);

	public abstract ISFSObject json2object(String paramString);

	public abstract ISFSArray json2array(String paramString);

	public abstract ISFSObject pojo2sfs(Object paramObject);

	public abstract Object sfs2pojo(ISFSObject paramISFSObject);

	public abstract SFSObject resultSet2object(ResultSet paramResultSet) throws SQLException;

	public abstract SFSArray resultSet2array(ResultSet paramResultSet) throws SQLException;
}