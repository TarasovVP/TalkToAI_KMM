package mapperimpls

import data.database.db_entities.Message
import domain.mappers.BaseMapper
import ui_models.MessageUIModel

interface MessageUIMapper : BaseMapper<Message, MessageUIModel>