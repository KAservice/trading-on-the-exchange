//---------------------------------------------------------------------------

#include <vcl.h>
#pragma hdrstop

#include "MainForm.h"
//---------------------------------------------------------------------------
#pragma package(smart_init)
#pragma resource "*.dfm"
TForm1 *Form1;
//---------------------------------------------------------------------------
__fastcall TForm1::TForm1(TComponent* Owner)
	: TForm(Owner)
{
}
//---------------------------------------------------------------------------
void __fastcall TForm1::ButtonLoadLibraryClick(TObject *Sender)
{
	dllIn=LoadLibrary("kasTXmlConnector.dll");

	DllGetServiceInfo = (DllGetServiceInfoType *) GetProcAddress(dllIn,"_kasGetServiceInfo");
	DllInitialize = (DllInitializeType *) GetProcAddress(dllIn,"_kasInitialize");
	DllSetLogLevel = (DllSetLogLevelType *) GetProcAddress(dllIn,"_kasSetLogLevel");
	DllSendCommand = (DllSendCommandType *) GetProcAddress(dllIn,"_kasSendCommand");
	DllSetCallback = (DllSetCallbackType *) GetProcAddress(dllIn,"_kasSetCallback");
	DllSetCallbackEx = (DllSetCallbackExType *) GetProcAddress(dllIn,"_kasSetCallbackEx");
	DllFreeMemory = (DllFreeMemoryType *) GetProcAddress(dllIn,"_kasFreeMemory");
	DllUnInitialize = (DllUnInitializeType *) GetProcAddress(dllIn,"_kasUnInitialize");


	DllkasLoadLibrary = (DllkasLoadLibraryType *) GetProcAddress(dllIn,"_kasLoadLibrary");
	DllkasFreeLibrary = (DllkasFreeLibraryType *) GetProcAddress(dllIn,"_kasFreeLibrary");

}
//---------------------------------------------------------------------------
void __fastcall TForm1::ButtonGetServiceInfoClick(TObject *Sender)
{
char* z=0;


z=	"<request>                     \
	<value>version</value>           \
	</request>";

char*  r;

int result = DllGetServiceInfo (z, &r);



bool res = DllFreeMemory(r);
}
//---------------------------------------------------------------------------
void __fastcall TForm1::ButtonInitializeClick(TObject *Sender)
{
UnicodeString ProgramCatalog=ExtractFileDir(Application->ExeName);
UnicodeString LogCatalog=ProgramCatalog+"\\Log";
//зададим каталог протоколов
if (DirectoryExists(LogCatalog)==false)
		{
		CreateDir(LogCatalog);
		}
LogCatalog=LogCatalog+"\\";
AnsiString s=LogCatalog;



char*  result = 0x0;
result = DllInitialize (s.c_str(),3);

if (result == 0)
	{
	ShowMessage("Ошибок нет");
	}
else
	{
	 ShowMessage(result);
	 DllFreeMemory(result);
	}
}
//---------------------------------------------------------------------------
void __fastcall TForm1::ButtonUnInitializeClick(TObject *Sender)
{
char* result =  DllUnInitialize();

if (result == 0)
	{
	ShowMessage("Ошибок нет");
	}
else
	{
	 ShowMessage("Ошибок нет");
	 DllFreeMemory(result);
	}
}
//---------------------------------------------------------------------------


bool TForm1::ReadDataCallback1(char* data)
{
bool result = true;

UnicodeString str=UTF8ToString(data);
ShowMessage(str);

return result;
}
//---------------------------------------------------------------------------
void __fastcall TForm1::ButtonSetCallbackClick(TObject *Sender)
{
bool result = DllSetCallback(&ReadDataCallback1);
}
//---------------------------------------------------------------------------
void __fastcall TForm1::ButtonFreeLibraryClick(TObject *Sender)
{
FreeLibrary(dllIn);
}
//---------------------------------------------------------------------------
void __fastcall TForm1::ButtonLoadLibraryTransaqClick(TObject *Sender)
{
DllkasLoadLibrary();
}
//---------------------------------------------------------------------------
void __fastcall TForm1::ButtonFreeLybraryTransaqClick(TObject *Sender)
{
DllkasFreeLibrary();
}
//---------------------------------------------------------------------------

void __fastcall TForm1::ButtonSetLogLevelClick(TObject *Sender)
{
DllSetLogLevel(2);
}
//---------------------------------------------------------------------------

void __fastcall TForm1::ButtonConnectClick(TObject *Sender)
{
char* z;


z= "	<command id=\"connect\">                                                        \
				<login>user_id</login>                                                \
				<password>user_password</password>                                    \
				<host>192.168.25.25</host>                                                \
				<port>2589</port>                                              \
				<language>ru</language>                                            \
				<autopos>true</autopos>                                         \
				<micex_registers>true</micex_registers>                         \
				<milliseconds>true</milliseconds>                               \
				<utc_time>true</utc_time>                                       \
				<rqdelay>100</rqdelay>                         \
				<session_timeout>120</session_timeout>       \
				<request_timeout>20                        \
				</request_timeout>                                                    \
				<push_u_limits>10</push_u_limits>                      \
				<push_pos_equity>10</push_pos_equity>                  \
				</command>     ";

char*  r;

r=DllSendCommand (z);


//DllFreeMemory(r);
}
//---------------------------------------------------------------------------

void __fastcall TForm1::ButtonDisconnectClick(TObject *Sender)
{
char* z;


z=	"<command id=\"disconnect\"/>";

char*  r;

r=DllSendCommand (z);


//DllFreeMemory(r);
}
//---------------------------------------------------------------------------

