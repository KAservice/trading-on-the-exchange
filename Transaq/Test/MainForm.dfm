object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'Form1'
  ClientHeight = 329
  ClientWidth = 715
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object ButtonLoadLibrary: TButton
    Left = 32
    Top = 32
    Width = 161
    Height = 25
    Caption = 'Load library'
    TabOrder = 0
    OnClick = ButtonLoadLibraryClick
  end
  object ButtonFreeLibrary: TButton
    Left = 506
    Top = 208
    Width = 129
    Height = 25
    Caption = 'Free library'
    TabOrder = 1
    OnClick = ButtonFreeLibraryClick
  end
  object ButtonGetServiceInfo: TButton
    Left = 32
    Top = 111
    Width = 161
    Height = 25
    Caption = 'GetServiceInfo'
    TabOrder = 2
    OnClick = ButtonGetServiceInfoClick
  end
  object ButtonInitialize: TButton
    Left = 32
    Top = 142
    Width = 161
    Height = 25
    Caption = 'Initialize'
    TabOrder = 3
    OnClick = ButtonInitializeClick
  end
  object ButtonUnInitialize: TButton
    Left = 506
    Top = 63
    Width = 129
    Height = 25
    Caption = 'UnInitialize'
    TabOrder = 4
    OnClick = ButtonUnInitializeClick
  end
  object ButtonSetCallback: TButton
    Left = 32
    Top = 208
    Width = 161
    Height = 25
    Caption = 'SetCallback'
    TabOrder = 5
    OnClick = ButtonSetCallbackClick
  end
  object ButtonLoadLibraryTransaq: TButton
    Left = 32
    Top = 63
    Width = 161
    Height = 25
    Caption = 'Load library Transaq'
    TabOrder = 6
    OnClick = ButtonLoadLibraryTransaqClick
  end
  object ButtonFreeLybraryTransaq: TButton
    Left = 506
    Top = 159
    Width = 129
    Height = 25
    Caption = 'Free library Transaq'
    TabOrder = 7
    OnClick = ButtonFreeLybraryTransaqClick
  end
  object ButtonSetLogLevel: TButton
    Left = 32
    Top = 272
    Width = 161
    Height = 25
    Caption = 'ButtonSetLogLevel'
    TabOrder = 8
    OnClick = ButtonSetLogLevelClick
  end
  object ButtonConnect: TButton
    Left = 264
    Top = 142
    Width = 161
    Height = 25
    Caption = 'Connect'
    TabOrder = 9
    OnClick = ButtonConnectClick
  end
  object ButtonDisconnect: TButton
    Left = 264
    Top = 173
    Width = 161
    Height = 25
    Caption = 'ButtonDisconnect'
    TabOrder = 10
    OnClick = ButtonDisconnectClick
  end
end
