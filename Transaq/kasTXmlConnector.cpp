//---------------------------------------------------------------------------

#include <windows.h>
#include "transaq_TransaqConnector.h"
#include <fstream.h>
#include <vcl.h>
//---------------------------------------------------------------------------
//   Important note about DLL memory management when your DLL uses the
//   static version of the RunTime Library:
//
//   If your DLL exports any functions that pass String objects (or structs/
//   classes containing nested Strings) as parameter or function results,
//   you will need to add the library MEMMGR.LIB to both the DLL project and
//   any other projects that use the DLL.  You will also need to use MEMMGR.LIB
//   if any other projects which use the DLL will be performing new or delete
//   operations on any non-TObject-derived classes which are exported from the
//   DLL. Adding MEMMGR.LIB to your project will change the DLL and its calling
//   EXE's to use the BORLNDMM.DLL as their memory manager.  In these cases,
//   the file BORLNDMM.DLL should be deployed along with your DLL.
//
//   To avoid using BORLNDMM.DLL, pass string information using "char *" or
//   ShortString parameters.
//
//   If your DLL uses the dynamic version of the RTL, you do not need to
//   explicitly add MEMMGR.LIB as this will be done implicitly for you
//---------------------------------------------------------------------------

		typedef bool (kas_tcallback(char* pData));
		typedef bool (kas_tcallbackEx(char* pData, void*));

extern "C" int __declspec (dllexport) kasGetServiceInfo(char* request,char** response);
extern "C" char* __declspec (dllexport) kasInitialize(char* logPath, int logLevel);
extern "C" char* __declspec (dllexport)	kasSetLogLevel(int logLevel);
extern "C" char* __declspec (dllexport)	kasSendCommand (char* pData);
extern "C" bool __declspec (dllexport)	kasFreeMemory  (char* pData);
extern "C" char* __declspec (dllexport)	kasUnInitialize (void);


extern "C" bool __declspec (dllexport) kasSetCallback(kas_tcallback * call);
extern "C" bool __declspec (dllexport) kasSetCallbackEx(kas_tcallbackEx*  call, void* userData);

extern "C" int __declspec (dllexport) kasLoadLibrary(void);
extern "C" int __declspec (dllexport) kasFreeLibrary(void);



		HINSTANCE dllIn;

		typedef int (__import DllTransaqGetServiceInfoType (BYTE* request, BYTE** response));
		typedef BYTE*(  __import DllTransaqInitializeType(BYTE* logPath, int logLevel));
		typedef BYTE* ( __import DllTransaqSetLogLevelType(int logLevel));
		typedef BYTE* (__import DllTransaqSendCommandType(BYTE* pData));
		typedef bool  (__import DllTransaqFreeMemoryType(BYTE* pData));
		typedef BYTE* (__import DllTransaqUnInitializeType(void));


		typedef bool (tcallback(BYTE* pData));
		typedef bool (tcallbackEx)(BYTE* pData, void*);

		typedef bool  (__import DllTransaqSetCallbackType(tcallback * pCallback));
		typedef bool  (__import DllTransaqSetCallbackExType(tcallbackEx*  pCallbackEx, void* userData));




		DllTransaqGetServiceInfoType * DllTransaqGetServiceInfo;
		DllTransaqInitializeType   *   DllTransaqInitialize;
		DllTransaqSetLogLevelType  *   DllTransaqSetLogLevel;
		DllTransaqSendCommandType  *   DllTransaqSendCommand;
		DllTransaqSetCallbackType   *  DllTransaqSetCallback;
		DllTransaqSetCallbackExType *  DllTransaqSetCallbackEx;
		DllTransaqFreeMemoryType    *  DllTransaqFreeMemory;
		DllTransaqUnInitializeType  *  DllTransaqUnInitialize;


		static bool ReadDataCallbackFromTransaq(BYTE* data);
		bool ReadDataCallbackFromTransaqForJava(BYTE* data);
        void OutputProtokol(char * string);

		kas_tcallback*  CallbackFunction;


		//JNIEnv * GlobalJNIEnv;
		JavaVM * GlobalJVM;
		jobject GlobalObject;
		JNIEnv * GlobalJNIEnv;
		bool flDetachCurrentThread=false;





#pragma argsused
BOOL WINAPI DllMain(HINSTANCE hinstDLL, DWORD fwdreason, LPVOID lpvReserved)
{
	return 1;
}
//---------------------------------------------------------------------------
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *jvm, void * reserved)

{
jint result = JNI_VERSION_1_8;
ShowMessage ("OnLoad");
GlobalJVM = jvm;
return result;
}
//---------------------------------------------------------------------------
JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *jvm, void * reserved)

{
OutputProtokol("Unload");
ShowMessage ("Unload");
}
//---------------------------------------------------------------------------











JNIEXPORT jint JNICALL Java_transaq_TransaqConnector_GetServiceInfo
  (JNIEnv *, jobject, jbyteArray, jbyteArray)
{

}
//---------------------------------------------------------------------------
JNIEXPORT jbyteArray JNICALL Java_transaq_TransaqConnector_LoadDllTransaq
  (JNIEnv *, jobject)
{
ShowMessage("Áóäåì çàãğóæàòü dll transaq");
int res = kasLoadLibrary();

ShowMessage("Çàãğóçèëè dll transaq");
jbyteArray result = 0;
return result;//!!!!!!ÎÁßÇÀÒÅËÜÍÎ ÂÎÇÂĞÀÙÀÅÌÎÅ ÇÍÀ×ÅÍÈÅ ÂÎ ÂÑÅÕ ÔÓÍÊÖÈßÕ
}
//---------------------------------------------------------------------------

JNIEXPORT jbyteArray JNICALL Java_transaq_TransaqConnector_UnLoadDllTransaq
  (JNIEnv *, jobject)
{

int res=kasFreeLibrary();
jbyteArray result = 0;
return result;//!!!!!!ÎÁßÇÀÒÅËÜÍÎ ÂÎÇÂĞÀÙÀÅÌÎÅ ÇÍÀ×ÅÍÈÅ ÂÎ ÂÑÅÕ ÔÓÍÊÖÈßÕ
}
//------------------------------------------------------------------------


JNIEXPORT jbyteArray JNICALL Java_transaq_TransaqConnector_SetCallback
  (JNIEnv *, jobject)
{

//bool result=true;
ShowMessage("SetCallback start");
bool res;

if (DllTransaqSetCallback!=0)
	{
	res=DllTransaqSetCallback(&ReadDataCallbackFromTransaqForJava);
	if (res==true) ShowMessage ("OK");
	else ShowMessage("Error");
	}
else
	{
	ShowMessage("DllTransaqSetCallback ğàâåí íóëş");
	}

//return result;
ShowMessage("SetCallback end");
jbyteArray result = 0;
return result;//!!!!!!ÎÁßÇÀÒÅËÜÍÎ ÂÎÇÂĞÀÙÀÅÌÎÅ ÇÍÀ×ÅÍÈÅ ÂÎ ÂÑÅÕ ÔÓÍÊÖÈßÕ
}
//-----------------------------------------------------------------------

JNIEXPORT jbyteArray JNICALL Java_transaq_TransaqConnector_Initialize
  (JNIEnv * jenv, jobject obj, jbyteArray logPath , jint logLevel)
{
//jbyteArray result=0;

//GlobalJNIEnv = 0;
GlobalObject = 0;
//GlobalJVM = 0;
//
//jenv->GetJavaVM(&GlobalJVM);
//
////GlobalJNIEnv = jenv;
GlobalObject = jenv->NewGlobalRef(obj);

//kasInitialize("K:\\DLL\\Transaq\\Output\\Log\\", 3);


//return result;
//
char * isCopy="";
char * char_logPath;
char_logPath = jenv->GetByteArrayElements(logPath, isCopy);
long sizeArray=jenv->GetArrayLength(logPath);





char *  buf  = (char *) malloc(sizeArray+1);
	strcpy(buf,char_logPath);
	buf[sizeArray]=0x0;
	jenv->ReleaseByteArrayElements(logPath,char_logPath, JNI_ABORT);

	OutputProtokol(buf);

	char* result_initialize=0x0;

	result_initialize = kasInitialize(buf,logLevel);
//free(buf);

//return result;

 if (result_initialize == 0)
	{
	ShowMessage("Âûïîëíèëè  kasInitialize áåç îøèáîê");
	//result = 0;
	}
 else
	{  //error
	ShowMessage("Îøèáêà kasInitialize");
	ShowMessage(result_initialize);
	//ñíà÷àëà íàäî îøèáêó ïåğåäàòü â Java
	//free(result_initialize);
	long len = strlen(result_initialize);
	//result = jenv->NewByteArray(len);
	//jenv->SetByteArrayRegion(result, 0, len, result_initialize);
	}





OutputProtokol("Çàâåğøèëè âûïîëíåíèå Java_transaq_TransaqConnector_Initialize");

jbyteArray result = 0;
return result;//!!!!!!ÎÁßÇÀÒÅËÜÍÎ ÂÎÇÂĞÀÙÀÅÌÎÅ ÇÍÀ×ÅÍÈÅ ÂÎ ÂÑÅÕ ÔÓÍÊÖÈßÕ
}
//-------------------------------------------------------------------------
JNIEXPORT jbyteArray JNICALL Java_transaq_TransaqConnector_UnInitialize
  (JNIEnv * jenv, jobject  obj)
{
char* result_uninitialize=0x0;

result_uninitialize = kasUnInitialize();


 if (result_uninitialize == 0)
	{
	ShowMessage("Âûïîëíèëè  kasUnInitialize áåç îøèáîê");
	}
 else
	{  //error
	ShowMessage("Îøèáêà kasUnInitialize");
	ShowMessage(UTF8ToString(result_uninitialize));
	//ñíà÷àëà íàäî îøèáêó ïåğåäàòü â Java
	free(result_uninitialize);
	}


ShowMessage("start jenv->DeleteGlobalRef( GlobalObject )");

jenv->DeleteGlobalRef( GlobalObject );

ShowMessage("end jenv->DeleteGlobalRef( GlobalObject )");


jbyteArray result = 0;
return result;//!!!!!!ÎÁßÇÀÒÅËÜÍÎ ÂÎÇÂĞÀÙÀÅÌÎÅ ÇÍÀ×ÅÍÈÅ ÂÎ ÂÑÅÕ ÔÓÍÊÖÈßÕ
}
//--------------------------------------------------------------------
JNIEXPORT jbyteArray JNICALL Java_transaq_TransaqConnector_SetLogLevel
  (JNIEnv *, jobject, jint)
{

}
//---------------------------------------------------------------------
JNIEXPORT jbyteArray JNICALL Java_transaq_TransaqConnector_SendCommand
  (JNIEnv * jenv, jobject , jbyteArray command)


{
char * isCopy="";
char * char_command = jenv->GetByteArrayElements(command, isCopy);
long sizeArray=jenv->GetArrayLength(command);


char *  buf  = (char *) malloc(sizeArray+1);

strcpy(buf,char_command);
buf[sizeArray]=0x0;
jenv->ReleaseByteArrayElements(command,char_command, JNI_ABORT);

OutputProtokol(buf);

char* result_command=0x0;

result_command = kasSendCommand(buf);

ShowMessage(UTF8ToString(result_command));

free(result_command);
free(buf);

OutputProtokol("Çàâåğøèëè âûïîëíåíèå Java_transaq_TransaqConnector_SendCommand");

jbyteArray result = 0;
return result;//!!!!!!ÎÁßÇÀÒÅËÜÍÎ ÂÎÇÂĞÀÙÀÅÌÎÅ ÇÍÀ×ÅÍÈÅ ÂÎ ÂÑÅÕ ÔÓÍÊÖÈßÕ

}
//--------------------------------------------------------------------




void OutputProtokol(char * string)
{

//string=strcpy(string,"\n");
const wchar_t *fileName=L"D:\\trading-on-the-exchange\\Transaq\\Output\\Log.txt";

ofstream outfile(fileName,ios::out|ios::app);

outfile<<string;
string = "\n";
outfile<<string;
outfile.close();

}
//------------------------------------------------------------------------------
//******************************************************************************
//-------------------------------------------------------------------------------
int  kasLoadLibrary(void)
{
	DllTransaqGetServiceInfo = 0;
	DllTransaqInitialize = 0;
	DllTransaqSetLogLevel = 0;
	DllTransaqSendCommand = 0;
	DllTransaqSetCallback = 0;
	DllTransaqSetCallbackEx = 0;
	DllTransaqFreeMemory = 0;
	DllTransaqUnInitialize = 0;


    dllIn=0;
	dllIn=LoadLibrary("D:\\trading-on-the-exchange\\Transaq\\Output\\txmlconnector.dll");

	if(dllIn==0)  ShowMessage("dllIn=0 Áèáëèîòåêà íå çàãğóæåíà");

	DllTransaqGetServiceInfo = (DllTransaqGetServiceInfoType *) GetProcAddress(dllIn,"GetServiceInfo");
	DllTransaqInitialize = (DllTransaqInitializeType *) GetProcAddress(dllIn,"Initialize");
	DllTransaqSetLogLevel = (DllTransaqSetLogLevelType *) GetProcAddress(dllIn,"SetLogLevel");
	DllTransaqSendCommand = (DllTransaqSendCommandType *) GetProcAddress(dllIn,"SendCommand");
	DllTransaqSetCallback = (DllTransaqSetCallbackType *) GetProcAddress(dllIn,"SetCallback");
	DllTransaqSetCallbackEx = (DllTransaqSetCallbackExType *) GetProcAddress(dllIn,"SetCallbackEx");
	DllTransaqFreeMemory = (DllTransaqFreeMemoryType *) GetProcAddress(dllIn,"FreeMemory");
	DllTransaqUnInitialize = (DllTransaqUnInitializeType *) GetProcAddress(dllIn,"UnInitialize");


if (DllTransaqGetServiceInfo == 0)
	{
	ShowMessage("DllTransaqGetServiceInfo == 0");
	}

if (DllTransaqInitialize == 0)
	{
	ShowMessage("DllTransaqInitialize == 0");
	}

if (DllTransaqSetLogLevel == 0)
	{
	ShowMessage("DllTransaqSetLogLevel == 0");
	}

if (DllTransaqSendCommand == 0)
	{
	ShowMessage("DllTransaqSendCommand == 0");
	}

if (DllTransaqSetCallback == 0)
	{
	ShowMessage("DllTransaqSetCallback == 0");
	}

if (DllTransaqSetCallbackEx == 0)
	{
	ShowMessage("DllTransaqSetCallbackEx == 0");
	}

if (DllTransaqFreeMemory == 0)
	{
	ShowMessage("DllTransaqSetCallback == 0");
	}

if (DllTransaqUnInitialize == 0)
	{
	ShowMessage("DllTransaqFreeMemory == 0");
	}
	return 1;
}
//---------------------------------------------------------------------------
int kasFreeLibrary(void)
{
ShowMessage("start FreeLibrary");
FreeLibrary(dllIn);
ShowMessage("end FreeLibrary");
return 1;
}
//---------------------------------------------------------------------------
int kasGetServiceInfo(char* request, char** response)
{
int result=0;
BYTE * z=request;
BYTE*  r=0;

result=DllTransaqGetServiceInfo(request,&r);
long size=strlen(r);

*response=(char*) malloc(size+1);
strcpy(*response,r);

bool res = DllTransaqFreeMemory (r);
return result;
}
//---------------------------------------------------------------------------
char* kasInitialize(char* logPath, int logLevel)
{
char* result=0x0;
ShowMessage("Start kasInitialize");

if (DllTransaqInitialize == 0)
	{
	ShowMessage("kasInitialize == 0");
	return result;
	}


 BYTE * error = DllTransaqInitialize(logPath, logLevel);

 if (error == 0)
	{

	}
 else
	{  //error
	long size=strlen(error);
	result=(char*) malloc(size+1);
	strcpy(result,error);
	bool res = DllTransaqFreeMemory (error);
	}
ShowMessage("End kasInitialize");
return result;

}
//---------------------------------------------------------------------------
char* 	kasSetLogLevel(int logLevel)
{
//char* result="12";
////bool res=DllTransaqSetCallback(&ReadDataCallbackFromTransaq);
////CallbackFunction("12345678");
//return result;
}
//---------------------------------------------------------------------------
char* 	kasSendCommand (char* pData)
{
char* result=0x0;
 BYTE * transaq_result = DllTransaqSendCommand(pData);

 if (transaq_result == 0)
	{

	}
 else
	{  //error
	long size=strlen(transaq_result);
    result=(char*) malloc(size+1);
	strcpy(result,transaq_result);
	bool res = DllTransaqFreeMemory (transaq_result);
	}

return result;

}
//---------------------------------------------------------------------------
bool kasFreeMemory  (char* pData)
{

bool result = true;

free(pData);
return result;

}
//---------------------------------------------------------------------------
char* 	kasUnInitialize (void)
{
ShowMessage(" start kasUnInitialize");
char* result=0x0;

if (DllTransaqUnInitialize == 0)
	{
	ShowMessage("kasUnInitialize == 0");
	return result;
	}


 BYTE * error = DllTransaqUnInitialize();

 if (error == 0)
	{

	}
 else
	{  //error
	long size=strlen(error);
    result=(char*) malloc(size+1);
	strcpy(result,error);
	bool res = DllTransaqFreeMemory (error);
	}
ShowMessage(" end kasUnInitialize");
return result;

}
//---------------------------------------------------------------------------
bool kasSetCallback(kas_tcallback * call)
{
bool result=true;
bool res;
//CallbackFunction=0;
CallbackFunction=call;
if (DllTransaqSetCallback!=0)
	{
	res=DllTransaqSetCallback(&ReadDataCallbackFromTransaq);
	if (res==true) ShowMessage ("OK");
	else ShowMessage("Error");
	}
else
	{
	//ShowMessage("DllTransaqSetCallback ğàâåí íóëş");
	}

return result;

}
//---------------------------------------------------------------------------
bool  kasSetCallbackExType(char* pData, void* n, void* userData)
{

CallbackFunction("12345678");
}
//---------------------------------------------------------------------------
bool ReadDataCallbackFromTransaq(BYTE* data)
{
char* out_data;
bool result=true;
	long size=strlen(data);
	out_data=(char*) malloc(size+1);
	strcpy(out_data,data);
	bool res = DllTransaqFreeMemory (data);
	result = CallbackFunction(out_data);

return result;
}
//----------------------------------------------------------------------------
bool ReadDataCallbackFromTransaqForJava(BYTE* data)
{
char* out_data;
bool result=true;
	long size=strlen(data);
	out_data=(char*) malloc(size+1);
	strcpy(out_data,data);
	bool res = DllTransaqFreeMemory (data);

//	ShowMessage(UTF8ToString(out_data));
AnsiString s=UTF8ToString(out_data)+"\n";
OutputProtokol(s.c_str());






	JNIEnv * jenv;
	int getEnvStat = GlobalJVM->GetEnv((void **)&jenv, JNI_VERSION_1_8);

	JavaVMAttachArgs args;
	args.version = JNI_VERSION_1_8;
	args.name = "Threadcallback";
	args.group = NULL;



	if (getEnvStat == JNI_EDETACHED)
		{  //"GetEnv: not attached"
		if (GlobalJVM->AttachCurrentThread((void **) &jenv, &args) != 0) {
			OutputProtokol("Failed to attach");
			}
		}
	else if (getEnvStat == JNI_OK)
		{
		GlobalJNIEnv = jenv;
		}
	else if (getEnvStat == JNI_EVERSION)
		{
		OutputProtokol("GetEnv: version not supported");
		}


	jclass cls = jenv->GetObjectClass(GlobalObject);
	jmethodID mid = 0;
	mid = jenv->GetMethodID(cls,"ReceiveBlock","([B)V");
	if (mid == NULL)
		{
		 ShowMessage("mid == 0");
		}

	long len = strlen(out_data);
//	ShowMessage(len);

	jbyteArray bytes;
	bytes = jenv->NewByteArray(len);

	long len_bytes = jenv->GetArrayLength(bytes);   //åñëè óäàëèòü ıòó ñòğîêó, íà ñëåäóşùåé ñòğîêå ïğîãğàììà java çàêğûâàåòñÿ àâğèéíî
	//ShowMessage(len_bytes);

//	if (bytes == 0)
//		{
//		 ShowMessage("bytes == 0");
//		}
//	else
//		{
//		ShowMessage("bytes íå ğàâíî 0");
//		}

	jenv->SetByteArrayRegion(bytes,0,len,out_data);
	jenv->CallVoidMethod(GlobalObject, mid, bytes) ;



   //	if (flDetachCurrentThread == true)
		{
		GlobalJVM->DetachCurrentThread();
		}
//free(out_data);
return result;

}
//---------------------------------------------------------------------------
