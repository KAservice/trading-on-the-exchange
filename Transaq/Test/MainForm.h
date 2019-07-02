//---------------------------------------------------------------------------

#ifndef MainFormH
#define MainFormH
//---------------------------------------------------------------------------
#include <Classes.hpp>
#include <Controls.hpp>
#include <StdCtrls.hpp>
#include <Forms.hpp>
//---------------------------------------------------------------------------
class TForm1 : public TForm
{
__published:	// IDE-managed Components
	TButton *ButtonLoadLibrary;
	TButton *ButtonFreeLibrary;
	TButton *ButtonGetServiceInfo;
	TButton *ButtonInitialize;
	TButton *ButtonUnInitialize;
	TButton *ButtonSetCallback;
	TButton *ButtonLoadLibraryTransaq;
	TButton *ButtonFreeLybraryTransaq;
	TButton *ButtonSetLogLevel;
	TButton *ButtonConnect;
	TButton *ButtonDisconnect;
	void __fastcall ButtonLoadLibraryClick(TObject *Sender);
	void __fastcall ButtonGetServiceInfoClick(TObject *Sender);
	void __fastcall ButtonInitializeClick(TObject *Sender);
	void __fastcall ButtonUnInitializeClick(TObject *Sender);
	void __fastcall ButtonSetCallbackClick(TObject *Sender);
	void __fastcall ButtonFreeLibraryClick(TObject *Sender);
	void __fastcall ButtonLoadLibraryTransaqClick(TObject *Sender);
	void __fastcall ButtonFreeLybraryTransaqClick(TObject *Sender);
	void __fastcall ButtonSetLogLevelClick(TObject *Sender);
	void __fastcall ButtonConnectClick(TObject *Sender);
	void __fastcall ButtonDisconnectClick(TObject *Sender);
private:	// User declarations
public:		// User declarations
	__fastcall TForm1(TComponent* Owner);


			HINSTANCE dllIn;

		typedef int (__import DllGetServiceInfoType (char* request, char** response));
		typedef char*(  __import DllInitializeType(char* logPath, int logLevel));
		typedef char* ( __import DllSetLogLevelType(int logLevel));
		typedef char* (__import DllSendCommandType(char* pData));
		typedef bool  (__import DllFreeMemoryType(char* pData));
		typedef char* (__import DllUnInitializeType(void));


		typedef bool (kas_tcallback(char* pData));
		typedef bool (kas_tcallbackEx)(char* pData, void*);


		typedef bool  (__import DllSetCallbackType(kas_tcallback * call));
		typedef bool  (__import DllSetCallbackExType(kas_tcallbackEx *  pCallbackEx, void* userData));


		typedef int (__import DllkasLoadLibraryType(void));
        typedef int (__import DllkasFreeLibraryType(void));

		DllGetServiceInfoType * DllGetServiceInfo;
		DllInitializeType   *   DllInitialize;
		DllSetLogLevelType  *   DllSetLogLevel;
		DllSendCommandType  *   DllSendCommand;
		DllSetCallbackType   *  DllSetCallback;
		DllSetCallbackExType *  DllSetCallbackEx;
		DllFreeMemoryType    *  DllFreeMemory;
		DllUnInitializeType  *  DllUnInitialize;

		DllkasLoadLibraryType * DllkasLoadLibrary;
		DllkasFreeLibraryType * DllkasFreeLibrary;


		static bool ReadDataCallback1(char* data);


};
//---------------------------------------------------------------------------
extern PACKAGE TForm1 *Form1;
//---------------------------------------------------------------------------
#endif
