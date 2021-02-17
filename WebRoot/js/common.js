/**
 * ��ȡ������
 * 
 * @returns
 */
function getContextPath()
{
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}

/**
 * ģ��java��StringBuffer
 * @returns
 */
function StringBuffer()
{
	this._strings_ = new Array;
}
StringBuffer.prototype.append = function(str)
{
	this._strings_.push(str);
};
StringBuffer.prototype.toString = function()
{
	return this._strings_.join("");
};

/**
 * ��ʽ������ yyyy-MM-dd HH:mm:ss
 * @param plusHour Сʱ�䶯��
 */
function formatDate(plusHour)
{
	var now=new Date();
	var year = now.getFullYear();
	var month = now.getMonth()+1;
	var date = now.getDate();
	var hour = now.getHours()+plusHour;
	var min = now.getMinutes();
	var sec = now.getSeconds();
	var sb = new StringBuffer();
	sb.append(year);
	sb.append("-");
	sb.append(month);
	sb.append("-");
	sb.append(date);
	sb.append(" ");
	sb.append(hour);
	sb.append(":");
	sb.append(min);
	sb.append(":");
	sb.append(sec);
	
	return sb.toString();
}

/**
 * ������߿�ѡ����
 * @param divId
 * @returns
 */
function highlight(divId)
{
	$("#"+divId).addClass("highlight");
}

/**
 * �ж�ajax���������Ƿ���ȷ
 * У��ͨ������true
 */
function parseAjaxData(data)
{
	// ��������� {"code":˵�����쳣
	if(data.indexOf('{"code":') < 0)
	{
		// ������� �����ض��򵽵�¼ҳ��
		if(data.indexOf('nclick="submitLogin') >= 0)
		{
			window.location.href = getContextPath()+"/login.jsp";
			return false;
		} else
		{
			alert("ϵͳ�쳣������ϵ����Ա��\r\n"+data);
			return false;
		}
	}
	
	return true;
}

/**
 * �������ϯ����
 * @param thiz �����selection
 */
function getUserInGroup(thiz)
{
	$.ajax({
		type : "POST",
		url : getContextPath() + "/groupManageGetInGroup.action",
		dataType : "text",
		data : "groupId=" + thiz.value,
		cache : false,
		success : function(data)
		{
			if (!parseAjaxData(data))
				return;
			var resultObj = eval("(" + data + ")");

			var users = resultObj.usersInGroup;
			$("#userNumberId option:gt(0)").each(function()
			{
				$(this).remove();
			});
			
			if (!users) // û���û�
				return;

			var sb = new StringBuffer();
			for ( var i = 0, j = users.length; i < j; i++)
			{
				sb.append('<OPTION value="');
				sb.append(users[i].number);
				sb.append('">');
				sb.append(users[i].name);
				sb.append('</OPTION>');
			}
			$("#userNumberId").append(sb.toString());
		},
		error : function()
		{
			alert("ϵͳ�쳣��");
		}
	});
}

function gotoCallcenter()
{
	alert("�뵽��������ִ����ز���");
}

