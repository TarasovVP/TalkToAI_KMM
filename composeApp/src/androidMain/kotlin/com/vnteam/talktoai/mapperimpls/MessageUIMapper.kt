package com.vnteam.talktoai.mapperimpls

import com.vnteam.talktoai.ui_models.MessageUIModel
import data.database.db_entities.Message
import domain.mappers.BaseMapper

interface MessageUIMapper : BaseMapper<Message, MessageUIModel>